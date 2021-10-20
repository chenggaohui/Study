package com.hhh.study.数据结构.tree;

import java.util.Comparator;
import java.util.Objects;
import java.util.Stack;

public class BSTree<V> implements MyTree<V>{

    private MyTreeNode<V> root;

    private int size;

    private Comparator<V> comparator;

    public BSTree(){
        this(null);
    }

    public BSTree(Comparator comparator){
        this.comparator = comparator;
    }

    @Override
    public void add(V value) {
        //如果还没有根节点
        if (root == null){
            root = new MyTreeNode(null,value,null,null);
            return;
        }

        MyTreeNode<V> node = root;
        MyTreeNode<V> parent = null;
        int i = 0;
        while (node != null){
            parent = node;
            i = compareElement(value, node.element);

            if (i == 0){
                node.element = value;
                return;
            }
            if (i > 0){
                node = node.rightChild;
            }
            if (i < 0){
                node = node.leftChild;
            }
        }

        MyTreeNode<V> myTreeNode = new MyTreeNode<>(parent, value, null, null);
        if (i > 0){
            parent.rightChild = myTreeNode;
        }else{
            parent.leftChild = myTreeNode;
        }
        size++;

    }

    @Override
    public V remove(V value) {
        checkoutElementNotNull(value);

        return null;
    }

    @Override
    public boolean contain(V value) {
        return searchNode(value) == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void print() {
        printFirst();
        printC();

    }

    private MyTreeNode searchNode(V value){
        checkoutElementNotNull(value);
        MyTreeNode<V> node = root;

        while (node != null){
            int temp = compareElement(value, node.element);
            if (temp == 0){
                return node;
            }
            if (temp > 0){
                node = node.rightChild;
            }
            if (temp < 0){
                node = node.leftChild;
            }
        }

        return null;


    }

    private int compareElement(V v1,V v2){
        if (comparator == null){
            return ((Comparable)v1).compareTo(v2);
        }else{
            return comparator.compare(v1, v2);
        }
    }

    private void checkoutElementNotNull(V value){
        if (Objects.isNull(value)){
            throw new NullPointerException("数据不能为空");
        }
    }


    private void printFirst(){
        System.out.print("前序遍历：");
        if (root == null){ return; }
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }
            if (node.leftChild != null){
                stack.push(node.leftChild);
            }

            System.out.print(node.toString() + ", ");
        }
        System.out.println();
    }

    private void printC(){
        System.out.println("层次遍历");
        Stack<MyTreeNode> stack1 = new Stack<>();
        Stack<MyTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while (!stack1.isEmpty()){
                MyTreeNode node = stack1.pop();
                if (node.rightChild != null){
                    stack2.push(node.rightChild);
                }
                if (node.leftChild != null){
                    stack2.push(node.leftChild);
                }

                System.out.print(node.toString() + ", ");
            }
            System.out.println();
            while (!stack2.isEmpty()){
                MyTreeNode node = stack2.pop();
                if (node.rightChild != null){
                    stack1.push(node.rightChild);
                }
                if (node.leftChild != null){
                    stack1.push(node.leftChild);
                }

                System.out.print(node.toString() + ", ");
            }
            System.out.println();
        }
    }
}
