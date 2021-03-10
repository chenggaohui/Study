package com.hhh.study.线程;

public class 线程中断 {


    public static void main(String[] args) throws Exception{

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":准备sleep");
                try {
                    int j = 0;
                    for (int i = 0; i < 1000000;i++){ j++;}
                    System.out.println(Thread.currentThread().getName() + ":苏醒");
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        thread.start();
        thread.interrupt();



    }
}
