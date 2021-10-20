package com.hhh.study.力扣;

import java.util.Arrays;

public class 快手预热题 {


    public static void main(String[] args) {

        int[] arr = {2,7,9,14,15,16,18,20};

        int[] search = search(arr, 19, 1);
        System.out.println(Arrays.toString(search));
    }


    public static int[] search(int[] list, int X,int N){
        if (list == null || list.length == 0 || list.length <= N){
            return list;
        }

        int[] arr = new int[N];
        if (X <= list[0]){
            System.arraycopy(list,0,arr,0,N);
            return arr;
        }
        if (X >= list[list.length-1]){
            System.arraycopy(list,list.length - N,arr,0,N);
            return arr;
        }

        int center = searchIndex(list, X, 0, list.length - 1);
        System.out.println("中间位置:"+center);
        int left = center,right = center + 1;
        for (int i = 0; i < N; i++){
            if (left < 0){
                System.arraycopy(list,right,arr,i,N - i);
                return arr;
            }
            if (right >= list.length){
                System.arraycopy(list,left - N + i + 1,arr,i,N - i);
                return arr;
            }

            if (X - list[left] <= list[right] - X){
                arr[i] = list[left--];
            }else{
                arr[i] = list[right++];
            }
        }
        return arr;

    }

    public static int searchIndex(int[] list, int X,int left,int right){
        if (left >= right){
            return left;
        }

        int center = (left + right) / 2;
        if (list[center] <= X && X <= list[center + 1]){
            return X - list[center] <= list[center + 1] - X ? center : center + 1;
        }
        if (list[center] > X){
            return searchIndex(list,X,left,center);
        }else{
            return searchIndex(list,X,center + 1,right);
        }

    }

}
