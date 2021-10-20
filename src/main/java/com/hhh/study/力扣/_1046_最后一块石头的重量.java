package com.hhh.study.力扣;

import java.util.Arrays;

public class _1046_最后一块石头的重量 {

    static int size;

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8};
        System.out.println(lastStoneWeight(arr));

    }

    public static int lastStoneWeight(int[] stones) {
        makeMaxHeap(stones);
        size = stones.length;
        while(true){
            int first = delete(stones);
            if (size == 0){
                return first;
            }
            int seconed = delete(stones);
            if (seconed != first){
                add(stones,Math.max(seconed,first)-Math.min(seconed,first));
            }else{
                if (size==0){
                    return 0;
                }
            }

        }
    }

    public static void makeMaxHeap(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }

        for (int i = arr.length/2 -1; i >= 0; i--){
            down(arr,i,arr.length-1);
        }
    }

    public static void down(int[] arr,int index,int maxIndex){
        int leftIndex = (index << 1) + 1;
        int rightIndex = (index + 1) << 1;
        if (leftIndex > maxIndex){
            return;
        }else if (leftIndex == maxIndex){
            if (arr[index] < arr[leftIndex]){
                arr[index] ^= arr[leftIndex];
                arr[leftIndex] ^= arr[index];
                arr[index] ^= arr[leftIndex];
            }
        }else{
            int tempIndex = arr[leftIndex] > arr[rightIndex] ? leftIndex : rightIndex;
            if (arr[tempIndex] > arr[index]){
                arr[index] ^= arr[tempIndex];
                arr[tempIndex] ^= arr[index];
                arr[index] ^= arr[tempIndex];
                down(arr,tempIndex,maxIndex);
            }
        }

    }

    public static void up(int[] arr,int index){
        if (index <= 0){
            return;
        }
        int parentIndex = (index - 1) >> 1;
        if (arr[index] > arr[parentIndex]){
            arr[index] ^= arr[parentIndex];
            arr[parentIndex] ^= arr[index];
            arr[index] ^= arr[parentIndex];
            up(arr,parentIndex);
        }
    }

    public static int delete(int[] arr){
        if (size < 0){
            return Integer.MIN_VALUE;
        }
       int result =  arr[0];
       arr[0] = arr[--size];
       down(arr,0,size-1);
       return result;
    }

    public static void add(int[] arr,int num){
        if (arr.length <= size){
            return;
        }
        arr[size++] = num;
        up(arr,size-1);
    }
}
