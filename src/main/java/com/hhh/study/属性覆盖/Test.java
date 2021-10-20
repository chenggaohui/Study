package com.hhh.study.属性覆盖;

public class Test {

    public static void main(String[] args) {
        Son son = new Son();
        Fathor fathor = new Son();

        Son sf = (Son)fathor;

//        System.out.println(son.age);
//        System.out.println(son.name);
//        System.out.println(son.address);
//        System.out.println(son.getAge());
//
//
//        System.out.println("===========");
//        System.out.println(fathor.age);
//        System.out.println(fathor.name);
//        System.out.println(fathor.address);
//        System.out.println(fathor.getAge());

        System.out.println(sf.age);
        System.out.println(sf.name);
        System.out.println(sf.address);
        System.out.println(sf.getAge());
//
    }
}
