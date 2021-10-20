package com.hhh.study.力扣;

public class _766_托普利茨矩阵 {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(arr));
    }


    public static boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1){
            return true;
        }

        for (int i = matrix.length - 1; i > 0; i--){
            for (int j = 1; j < matrix[i].length; j++){
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;

    }
}
