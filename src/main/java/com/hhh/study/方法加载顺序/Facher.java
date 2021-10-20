package com.hhh.study.方法加载顺序;

public class Facher {

    static{
        System.out.println("facher 静态代码块执行。。。");
    }

    {
        System.out.println("facher 代码块执行。。。");
    }

    public Facher (){
        System.out.println("facher 构造执行。。。");
    }
}
