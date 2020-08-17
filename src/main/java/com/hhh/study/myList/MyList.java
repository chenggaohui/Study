package com.hhh.study.myList;

public interface MyList<T> {

    public boolean add(T value);

    public T set(int index, T value);

    public T remove(int index);

    public boolean isEmpty();

    public boolean contains(T value);

    public void clear();

    public T indexOf(T value);
}
