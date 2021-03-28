package com.hhh.study.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(()->{
            System.out.println("子线程执行结束........");
        });
        thread.start();
        System.out.println("等待子线程执行结束！");
        thread.join();
        System.out.println("Main线程执行结束");
    }


    @Test
    public void test1(){

        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
//        String si = "没人比我更懂java";
//        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println("没人比我更懂java".toCharArray().length);
//        System.out.println(s == si.intern());
    }

    


}
