package com.hhh.study.数据结构.myList;

public interface MyList<E> {

    public boolean add(E value);

    public E set(int index, E value);

    public E remove(int index);

    public boolean isEmpty();

    public boolean contains(E value);

    public void clear();

    public int indexOf(E value);
}
