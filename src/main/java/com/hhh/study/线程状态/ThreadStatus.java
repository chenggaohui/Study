package com.hhh.study.线程状态;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatus {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test2();

    }

    public static void test1() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    reentrantLock.lock();
                    while (true) {
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "T1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    reentrantLock.lock();
                    while (true) {
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "T2");
        t2.start();

        t1.join();
        t2.join();
    }

    public static void test2() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (ThreadStatus.class){
                    while (true){}
                }
            }
        }, "T1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

               synchronized (ThreadStatus.class){
                   while (true){

                   }
               }
            }
        }, "T2");
        t2.start();

        t1.join();
        t2.join();
    }
}
