package com.hhh.study.Test;

import java.util.concurrent.CountDownLatch;

public class 线程安全 {

    static volatile int count = 0;

    static CountDownLatch cdl = new CountDownLatch(1000);

    public static void main(String[] args) throws Exception {
        CountRunnable countRunnable = new CountRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(countRunnable).start();
        }
        cdl.await();
        System.out.println(count);
    }

    static class CountRunnable implements Runnable {

        private void count() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        @Override
        public void run() {
            count();
            cdl.countDown();
        }

    }
}
