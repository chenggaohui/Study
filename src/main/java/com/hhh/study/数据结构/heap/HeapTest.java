package com.hhh.study.数据结构.heap;

import java.util.Comparator;

public class HeapTest {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int[] arr = {1,12,7,62,41,30,28,16,22,13,19,17,18,36};
        for (int i:arr){
            maxHeap.add(i);
        }
        System.out.println("原始："+maxHeap.toString());
        while (maxHeap.getSize()>0){
            System.out.print("弹出："+maxHeap.pop()+"~~~~");
            System.out.println("目前:"+maxHeap.toString());
        }

    }
}
