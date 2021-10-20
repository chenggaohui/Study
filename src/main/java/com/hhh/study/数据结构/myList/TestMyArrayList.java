package com.hhh.study.数据结构.myList;

import com.hhh.study.属性覆盖.Fathor;

import java.util.*;


public class TestMyArrayList {
    public static void main(String[] args) {
//        MyList<String> myList = new MyArrayList<>(1);
//
//        List<String> list = new ArrayList<>();
//        list.add("0");
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            iterator.next();
//            iterator.remove();
//            iterator.remove();
//        }

        System.out.println("args参数："+ args.length);

        Fathor[] fathors = new Fathor[]{new Fathor()};
        System.out.println(fathors[0]);
        Fathor[] fathors1 = Arrays.copyOf(fathors, 1);
        System.out.println(fathors1[0]);
        fathors1[0].age = "111";
        System.out.println(fathors[0]);

    }
}
