package com.hhh.study.myList;

import com.hhh.study.myList.Impl.MyArrayList;
import com.hhh.study.属性覆盖.Fathor;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
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
