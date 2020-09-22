package com.hhh.study.Test;



import com.hhh.study.属性覆盖.Fathor;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class Test01 {

    @Test
    public void testSchedule(){
//        ReflectionUtils.makeAccessible();
        System.out.println(null == null);
    }

    private static final Map<String, Consumer> map;

    private static final ExecutorService executorService;


    static {
        executorService = Executors.newCachedThreadPool();
        map = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ReentrantLock reentrantLock = new ReentrantLock();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    reentrantLock.lock();
//                    while (true) {
//                    }
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }, "T1");
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    reentrantLock.lock();
//                    while (true) {
//                    }
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }, "T2");
//        t2.start();
//
//        t1.join();
//        t2.join();

        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                    System.out.println("前。。。");
                    try {
                        TimeUnit.MILLISECONDS.sleep(10000000);
                    } catch (Exception e) {
                        System.out.println("异常");
                    }
                    lock.unlock();

                    System.out.println("后。。。");
                }

        });


        thread.start();

    }
}
