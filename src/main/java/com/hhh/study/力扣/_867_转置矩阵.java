package com.hhh.study.力扣;

import java.util.Arrays;

public class _867_转置矩阵 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};

        int[][] transpose = transpose2(arr);
        for (int[] i : transpose){
            System.out.println(Arrays.toString(i));
        }

    }


    public static int[][] transpose(int[][] matrix) {

        if (matrix == null || matrix.length <= 1){
            return matrix;
        }

        int length = matrix.length;

        for (int i = 0; i < length - 1; i++){

            for (int j = 1; j < length - i; j++){

                matrix[i][j + i] ^= matrix[j + i][i];
                matrix[j + i][i] ^= matrix[i][j + i];
                matrix[i][j + i] ^= matrix[j + i][i];
            }
        }

        return matrix;
    }

    public static int[][] transpose2(int[][] matrix) {
        int[][] result;

        if (matrix == null || matrix.length <= 0){
            return matrix;
        }
        result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
