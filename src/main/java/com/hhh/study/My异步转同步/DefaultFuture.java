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

public class DefaultFuture extends CompletableFuture<Object> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFuture.class);
    private static final int DEFAULT_TIMEOUT = 2 * 1000;

    private static final Map<String, DefaultFuture> FUTURES = new ConcurrentHashMap<>();



    private final String requestId;
    private final int timeOut;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private volatile Object response;

    private final long startTime = System.currentTimeMillis();

    public DefaultFuture(String requestId,int timeOut){
        this.requestId = requestId;
        this.timeOut = timeOut <= 0 ? DEFAULT_TIMEOUT : timeOut;
        System.out.println("放入:"+requestId);
        FUTURES.put(requestId,this);
    }

    public Object tryGet() throws InterruptedException, ExecutionException, TimeoutException {
        return tryGet(timeOut);
    }

    public Object tryGet(long timeout) throws InterruptedException, ExecutionException, TimeoutException {
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

    public static void received(String requestId, Object response) {
        try {
            DefaultFuture future = FUTURES.remove(requestId);
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

    private void doReceived(Object res) {
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

    //TODO 定时清理过期的请求
}
