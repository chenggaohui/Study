package com.hhh.study.数据结构.tree;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.Comparator;

public class TestTree {

    @Test
    public void testBST(){
        MyTree<Integer> myTree = new BSTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -o2;
            }
        });
        int[] arr = {10, 83, 69, 97, 28, 61, 26, 80, 25};
        System.out.println("插入数据：");
        for (int i : arr){
            myTree.add(i);
            System.out.print(i +", ");
        }
        System.out.println();
        System.out.println("结果:");
        myTree.print();
    }
}
