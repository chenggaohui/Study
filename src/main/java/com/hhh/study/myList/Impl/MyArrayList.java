package com.hhh.study.myList.Impl;

import com.hhh.study.myList.MyList;

import java.util.Arrays;

/**
 * @author CGH
 * @date 2020-08-17
 * @param <E>
 */

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_SIZE=10;

    private int size;

    private Object[] elements;

    public MyArrayList(){
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int capacity) {
        if (capacity<0){
            throw new IllegalArgumentException("MyArrayList capacity cannot be less than zero, size: "+capacity);
        }
        this.elements = new Object[capacity];
    }


    @Override
    public boolean add(E value) {
        return false;
    }

    @Override
    public E set(int index, E value) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(E value) {
        return 0;
    }



    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
