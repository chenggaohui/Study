package com.hhh.study.My异步转同步;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultFuture<T> extends CompletableFuture<T> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFuture.class);
    private static final int DEFAULT_TIMEOUT = 2 * 1000;

    private static final Map<String, DefaultFuture> FUTURES = new ConcurrentHashMap<>();

    static{
        Thread thread = new Thread(new RemotingInvocationTimeoutScan(),"ResponseTimeoutScanTimer");
        //将此线程设置为守护线程
        thread.setDaemon(true);
        thread.start();
    }

    private final String key;
    private final int timeOut;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private volatile T response;
    private final long startTime = System.currentTimeMillis();

    public static int getDefaultTimeout() {
        return DEFAULT_TIMEOUT;
    }

    public static Map<String, DefaultFuture> getFUTURES() {
        return FUTURES;
    }

    public String getKey() {
        return key;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getDone() {
        return done;
    }

    public T getResponse() {
        return response;
    }

    public long getStartTime() {
        return startTime;
    }

    public DefaultFuture(String key, int timeOut){
        this.key = key;
        this.timeOut = timeOut <= 0 ? DEFAULT_TIMEOUT : timeOut;
        FUTURES.put(key,this);
    }

    public T tryGet() throws TimeoutException {
        return tryGet(timeOut);
    }

    public T tryGet(long timeout) throws  TimeoutException {
        if (timeout <= 0) {
            timeout = DEFAULT_TIMEOUT;
        }
        if (!isDone()) {
            long start = System.currentTimeMillis();
            lock.lock();
            try {
                while (!isDone()) {
                    done.await(timeout, TimeUnit.MILLISECONDS);
                    if (isDone() || System.currentTimeMillis() - start > timeout) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            if (!isDone()) {

                throw new TimeoutException("异步请求超时!!!");
            }
        }
        return response;
    }

    public static void received(String key, Object response) {
        try {
            DefaultFuture future = FUTURES.remove(key);
            if (future != null) {
                future.doReceived(response);
            } else {
                logger.warn("The timeout response finally returned at "
                        + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()))
                        + ", response " + response);
            }
        } finally {
        }
    }

    private void doReceived(T res) {
        lock.lock();
        try {
            response = res;
            if (done != null) {
                done.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isDone() {
        return response != null;
    }


    private static class RemotingInvocationTimeoutScan implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    for (DefaultFuture future : FUTURES.values()) {
                        if (future == null || future.isDone()) {
                            continue;
                        }
                        if (System.currentTimeMillis() - future.getStartTime() > future.getTimeOut()) {

                            System.out.println("自动扫描发现请求超时的:"+future.getKey());
                            // create exception response.
                            //根据业务修改返回对象
                            Object timeoutResponse = new Object();
                            // set timeout status.
                            // handle response.
                            DefaultFuture.received(future.getKey(), timeoutResponse);
                        }
                    }
                    Thread.sleep(30);
                } catch (Throwable e) {
                    logger.error("Exception when scan the timeout invocation of remoting.", e);
                }
            }
        }
    }
}
