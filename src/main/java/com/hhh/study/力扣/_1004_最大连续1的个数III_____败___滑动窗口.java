package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1004_最大连续1的个数III_____败___滑动窗口 {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(longestOnes2(arr,K));

    }



    public static int longestOnes(int[] A, int K) {

        if (A == null){
            return 0;
        }

        int temp = K;
        int maxCount = 0;
        int tempCount = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] == 1){
                tempCount++;
            }else{
                if (temp > 0){
                    tempCount++;
                    temp--;
                }else{
                    temp = K;
                    maxCount = maxCount > tempCount ? maxCount : tempCount;
                    tempCount = 0;

                }
            }
        }

        tempCount += temp;
        return maxCount > tempCount ? maxCount : tempCount;

    }

    public static int longestOnes2(int[] A, int K) {

        if(A == null){
            return 0;
        }
        int result = 0;

        int[] count = new int[A.length];
        int index = 0;

        int sign = A[0];
        int temp = 0;
        for (int i : A){

            if (i == sign){
                if (i == 1){
                    temp++;
                }else{
                    temp--;
                }
            }else{
                sign = i;
                count[index++] = temp;
                temp = i == 1 ? 1 : -1;
            }
        }


        count[index] = temp;
        temp = K;


        int left = 0,right = 0;
        int tempCount = 0;
        while(count[right] != 0){

            if (count[right] > 0){
                tempCount += count[right++];
            }else{
                if ((temp += count[right]) >= 0){
                    tempCount += count[right++];
                }else{
                    right++;
                    result = result > tempCount ? result : tempCount;
                    tempCount = 0;
                    temp = K;
                }
            }
        }

        tempCount += temp;

        return result > tempCount ? result : tempCount;

    }
}
