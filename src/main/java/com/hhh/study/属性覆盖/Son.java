package com.hhh.study.属性覆盖;

public class Son extends Fathor{

    public String age = "18";

    public static String name = "Son";

    public final static String address = "son类";

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
