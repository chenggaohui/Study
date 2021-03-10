package com.hhh.study.力扣;

public class _304_二维区域和检索矩阵不可变 {


    int[][] remakeArr = null;

    public _304_二维区域和检索矩阵不可变(int[][] matrix) {

        this.remakeArr = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++){

            remakeArr[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++){
                int count = matrix[i][j];
                if (i >= 1){
                    count += this.remakeArr[i - 1][j];
                }
                if (j >= 1){
                    count += this.remakeArr[i][j - 1];
                }
                if (i >= 1 && j >= 1){
                    count -= this.remakeArr[i-1][j - 1];
                }

                this.remakeArr[i][j] = count;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (remakeArr == null){
            return 0;
        }
        int result = remakeArr[row2][col2];
        if (row1 > 0){
            result -= remakeArr[row1 - 1][col2];
        }
        if (col1 > 0){
            result -= remakeArr[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0){
            result += remakeArr[row1 - 1][col1 - 1];
        }
        return result;
    }
}
