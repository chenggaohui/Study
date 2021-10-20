package com.hhh.study.线程池测试;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolTest {
    static LinkedBlockingQueue queue = new LinkedBlockingQueue<>(50);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,1000, TimeUnit.SECONDS,queue);
        for (int i = 0; i < 20; i++){
            threadPoolExecutor.execute(new Task());
            System.out.println("排队执行任务个数:"+queue.size());
        }

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("执行者："+ Thread.currentThread().getName());
            try{
                Thread.sleep(100);
                System.out.println("排队执行任务个数:"+queue.size());
            }catch (Exception e){
                System.out.println(e);
            }
    }
    }
}
