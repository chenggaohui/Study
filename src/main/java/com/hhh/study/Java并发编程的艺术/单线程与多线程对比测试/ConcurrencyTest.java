package com.hhh.study.Java并发编程的艺术.单线程与多线程对比测试;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ConcurrencyTest {

    private static final long count = 10000000000L;

    public static void main(String[] args) throws InterruptedException {


        concurrent();
        System.out.println("=============="+LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        serial();

    }

    private static void concurrent() throws InterruptedException {
        System.out.println("多线程:");
        long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i <= count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();


        int b = 0;

        for (long i=0;i<=count;i++){
            b+=5;
        }
        thread.join();

        System.out.println("多线程耗时:"+(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()-start));
    }

    private static void serial(){
        System.out.println("单线程:");
        long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        int a = 0;
        for (long i=0;i<=count;i++){
            a+=5;
        }

        int b = 0;

        for (long i=0;i<=count;i++){
            b+=5;
        }

        System.out.println("单线程耗时:"+(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()-start));
    }
}
