package com.hhh.study.力扣;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class _54_螺旋矩阵 {

//    class Inner {
//        public String  v1 = "Fake News";
//        public String v2 = "Go ahead";
//    }
//
//    private static String GetVal() {
//        try {
//            return Inner.class.newInstance().v1;
//        } catch (Exception e) {
//            try {
//                System.out.println(e);
//                return Inner.class.getDeclaredConstructor(_54_螺旋矩阵.class).newInstance((_54_螺旋矩阵)null).v2;
//            } catch (Exception ee) {
//                ee.printStackTrace();
//                return "Fake News, Go ahead";
//            }
//        }
//    }
//    public static void main(String[] args) {
//
//        System.out.println(GetVal());
//    }



    private static volatile int s = 0;
    private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
            0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            async.execute(()-> s++);
        }
        Thread.sleep(5000L);
        System.out.println(s);
    }

}
