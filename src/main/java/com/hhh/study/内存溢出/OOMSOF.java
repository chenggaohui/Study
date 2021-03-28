package com.hhh.study.内存溢出;

import java.util.concurrent.atomic.AtomicInteger;

public class OOMSOF {

    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        test();
    }




    private static void test(){
        System.out.println(count.incrementAndGet());
        test();
    }

    private static void test2(){
        System.out.println(count.incrementAndGet());
        test();
    }
}
