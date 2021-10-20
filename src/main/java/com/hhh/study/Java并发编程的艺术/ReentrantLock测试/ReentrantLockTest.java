package com.hhh.study.Java并发编程的艺术.ReentrantLock测试;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ReentrantLockTest {

    //需要继承ReentrantLock把getQueuedThreads()方法暴露出来
    public class MyReentrantLock extends ReentrantLock{

        public MyReentrantLock(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<>(super.getQueuedThreads());
            //由于是逆序输出的所以进行翻转,不信可以看输入线程队列的源码
            Collections.reverse(list);
            return list;
        }
    }

    public static class Job extends Thread{

        public MyReentrantLock reentrantLock;
        public Job(MyReentrantLock reentrantLock){
            this.reentrantLock = reentrantLock;
        }
        @Override
        public void run() {

            for (int i = 0; i < 2; i++){
                reentrantLock.lock();
                List<String> collect = reentrantLock.getQueuedThreads().stream().map(e -> {
                    return e.getName();
                }).collect(Collectors.toList());

                System.out.println("当前线程:"+Thread.currentThread().getName()+",阻塞队列线程:"+collect);

                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                }catch (Exception e){}
                reentrantLock.unlock();
            }
        }
    }

    @Test
    public void testNotFair() throws InterruptedException {
        MyReentrantLock myReentrantLock = new MyReentrantLock(false);
        for (int i=0;i<5;i++){
            Job job = new Job(myReentrantLock);
            job.setName(i+"");
            job.start();
        }
        Thread.currentThread().join(2000);
    }

    @Test
    public void testFair() throws InterruptedException {
        MyReentrantLock myReentrantLock = new MyReentrantLock(true);
        for (int i=0;i<5;i++){
            Job job = new Job(myReentrantLock);
            job.setName(i+"");
            job.start();
        }
       Thread.currentThread().join(2000);
    }
}
