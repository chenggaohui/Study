package com.hhh.study.myList;

import com.hhh.study.myList.Impl.MyArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<String> myList = new MyArrayList<>(1);

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
            iterator.remove();
        }

    }
}
