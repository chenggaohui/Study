package com.hhh.study.力扣;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _922_按奇偶排序数组II {

    public static void main(String[] args) {
        int[] arr = {4,1,1,0,1,0};
        int[] ints = sortArrayByParityII2(arr);
        System.out.println(Arrays.toString(ints));

    }


    public static int[] sortArrayByParityII(int[] A) {

        Stack<Integer> stack = new Stack<>();
        boolean sign = true;
        for (int i = 0; i < A.length; i++){
            if (((A[i] + i) & 1) == 1){
                if (stack.isEmpty()){
                    stack.push(i);
                    sign = (i & 1) == 1;
                }else{
                    if (sign && (i & 1) == 0){
                        Integer index = stack.pop();
                        A[i] = A[index] ^ A[i];
                        A[index] = A[index] ^ A[i];
                        A[i] = A[index] ^ A[i];


                    }else if(!sign && (i & 1) == 1){
                        Integer index = stack.pop();
                        A[i] = A[index] ^ A[i];
                        A[index] = A[index] ^ A[i];
                        A[i] = A[index] ^ A[i];
                    }else{
                        stack.push(i);
                    }
                }
            }
        }

        return A;
    }


    public static int[] sortArrayByParityII2(int[] A) {

        int i = 0,j = 1;
        boolean signI = false,signJ = false;
        while(i < A.length && j < A.length){
            if (signI && signJ){
                A[i] = A[i] ^ A[j];
                A[j] = A[i] ^ A[j];
                A[i] = A[i] ^ A[j];
                signI = false;
                signJ = false;
            }
            if (!signI && ((A[i] & 1) == 0)){
                i+=2;
            }else{
                signI = true;
            }
            if (!signJ && ((A[j] & 1) == 1)){
                j+=2;
            }else{
                signJ = true;
            }
        }

        return A;
    }
}
