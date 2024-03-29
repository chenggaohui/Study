package com.hhh.study.力扣;

import java.util.Arrays;

public class _455_分发饼干 {

    public static void main(String[] args) {
        int[] g = {123,34,123,6,2341,623,466,5,67,56,74,3,63,56,234};
        quickSort(g,0,g.length-1);
        System.out.println(Arrays.toString(g));

    }


    public static int findContentChildren(int[] g, int[] s) {

        if (g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }

        int min = s[0],max = s[0];

        for (int i : s){
            min = min < i ? min : i;
            max = max > i ? max : i;
        }

        int[] sign = new int[max-min+1];
        for (int i : s){
            sign[i-min]++;
        }

        int result = 0;
        for (int j : g){
            int i = j - min < 0 ? 0 : j - min;
            for (;i < sign.length;i++){
                if (sign[i] > 0){
                    sign[i]--;
                    result++;
                    break;
                }
            }

        }
        return result;

    }


    public static int findContentChildren2(int[] g, int[] s) {

        return 0;

    }

    public static void quickSort(int[] arr, int start, int end){

        if (start > end){
            return;
        }

        int i = start;
        int j = end;
        int temp = arr[start];
        while (i < j){
            while(i < j && arr[j] >= temp){
                j--;
            }
            while (i < j && arr[i] <= temp){
                i++;
            }
            if (i < j){
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }
        System.out.println("交换前：" + arr[start] +","+arr[i]);
//        arr[i] ^= arr[start];
//        arr[start] ^= arr[i];
//        arr[i] ^= arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        System.out.println("交换后：" + arr[start] +","+arr[i]);
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);

    }

    public static void quickSort2(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {

                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        System.out.println("交换前：" + arr[low] +","+arr[i]);
        arr[low] = arr[i];
        arr[i] = temp;
        System.out.println("交换后：" + arr[low] +","+arr[i]);
        //递归调用左半数组
        quickSort2(arr, low, i-1);
        //递归调用右半数组
        quickSort2(arr, i+1, high);
    }


}
