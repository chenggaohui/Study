package com.hhh.study.力扣;

import java.util.Arrays;

public class _832_翻转图像 {

    public static void main(String[] args) {

        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(arr);

        for(int[] i : ints){
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {

        if (A == null || A.length == 0){
            return A;
        }

        for (int i = 0;i < A.length;i++){
            int count = (A.length + 1) / 2;

            for (int j = 0; j < count; j++){
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - 1 - j] ^ 1;
                A[i][A[i].length - 1 - j] = temp ^ 1;
            }
        }

        return A;

    }
}
