package com.hhh.study.力扣;

public class _941_有效的山脉数组 {

    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        int[] arr1 = {9,8,7,6,5,4,3,2,1,0};
        int[] arr2 = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};
        System.out.println(validMountainArray(arr1));

    }

    public static boolean validMountainArray(int[] A) {

        if (A==null || A.length<3){
            return false;
        }

        int index = 0;
        int max = A[0];
        boolean sign = false;
        if (A[0]>=A[1]){
            return false;
        }
        for (;index<A.length-1;index++){
            sign = true;
            if (A[index+1]>max){
                max = A[index+1];
            }else{
                index++;
                break;
            }
        }

        for (;sign&&index<A.length;index++){
            if (A[index]<max){
                sign = true;
                max = A[index];
            }else{
                return false;
            }
        }
        return sign;

    }
}
