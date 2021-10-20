package com.hhh.study.数据结构.tree;

public interface MyTree<V> {

    void add(V value);

    V remove(V value);

    boolean contain(V value);

    int size();

    void clear();

    void print();


}
