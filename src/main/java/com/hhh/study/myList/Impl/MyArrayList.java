package com.hhh.study.myList.Impl;

import com.hhh.study.myList.MyList;

public class MyArrayList<T> implements MyList {

    private int size;

    private T[] elements;

    @Override
    public boolean add(Object value) {
        return false;
    }

    @Override
    public Object set(int index, Object value) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public void clear() {
        this.size=0;
    }

    @Override
    public Object indexOf(Object value) {
        return null;
    }
}
