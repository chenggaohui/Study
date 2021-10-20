package com.hhh.study.方法加载顺序;

public class Son extends Facher{

    static{
        System.out.println("son 静态代码块执行。。。");
    }

    {
        System.out.println("son 代码块执行。。。");
    }

    public Son (){
        System.out.println("son 构造执行。。。");
    }
}
