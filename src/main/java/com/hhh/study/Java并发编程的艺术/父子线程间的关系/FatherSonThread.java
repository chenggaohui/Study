package com.hhh.study.Java并发编程的艺术.父子线程间的关系;

public class FatherSonThread {

    static boolean num = false;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                num=true;
            }
        });
        thread.start();

        for (int i = 0; i < 10000; i++) {
            num=false;
        }
        thread.join();

        System.out.println("结果:"+num);

    }

}
