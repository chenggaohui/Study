package com.hhh.study.属性覆盖;

public class Fathor {
    public String age="30";
    public static String name = "fathor";

    public final static String address = "fathor类";

    public String getAge() {
        return address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Fathor{" +
                "age='" + age + '\'' +
                '}';
    }
}
