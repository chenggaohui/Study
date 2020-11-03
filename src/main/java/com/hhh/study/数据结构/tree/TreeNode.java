package com.hhh.study.数据结构.tree;

class MyTreeNode<V> {

    public MyTreeNode parent;

    public V element;

    public MyTreeNode leftChild;

    public MyTreeNode rightChild;

    public MyTreeNode(MyTreeNode parent, V element, MyTreeNode leftChild, MyTreeNode rightChild) {
        this.parent = parent;
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return element+"";
    }
}
