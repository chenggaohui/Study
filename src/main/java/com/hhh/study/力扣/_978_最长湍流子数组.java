package com.hhh.study.力扣;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _978_最长湍流子数组 {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {0,8,45,88,48,68,28,55,17,24};

        System.out.println(maxTurbulenceSize(arr));
    }


    public static int maxTurbulenceSize(int[] arr) throws InterruptedException {

        if (arr == null) return 0;
        if (arr.length <=1) return arr.length;

        int max = 1;
        int temp = 1;
        boolean sign = arr[0] > arr[1];
        for (int i = 0; i < arr.length-1;){

            if (sign && arr[i] > arr[i+1]){
                temp++;
                sign = !sign;
                i++;
                continue;
            }

            if (!sign && arr[i] < arr[i+1]){
                temp++;
                sign = !sign;
                i++;
                continue;
            }


            max = max > temp ? max : temp;
            temp = 1;
            sign = arr[i] > arr[i+1];

            if (arr[i] == arr[i+1]){
                i++;
            }
        }
        max = max > temp ? max : temp;
        return max;

    }
}
