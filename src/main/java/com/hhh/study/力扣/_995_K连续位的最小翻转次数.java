package com.hhh.study.力扣;

public class _995_K连续位的最小翻转次数 {

    public static void main(String[] args) {

        int[] arr = {1,1,0};
        int K = 2;
        System.out.println(minKBitFlips(arr,K));

    }



    public static int minKBitFlips(int[] A, int K) {

        if (A == null || A.length == 0){
            return -1;
        }
        int count = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] == 0){
                if (i > A.length - K){
                    return -1;
                }

                for (int j = 0; j < K; j++){
                    A[i + j] ^= 1;
                }

                count++;
            }
        }

        return count;
    }
}
