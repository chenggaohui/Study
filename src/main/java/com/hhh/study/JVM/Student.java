package com.hhh.study.JVM;

public class Student {

    public static final String name = "HH";
    static {
        System.out.println("Student类加载");
    }
}
