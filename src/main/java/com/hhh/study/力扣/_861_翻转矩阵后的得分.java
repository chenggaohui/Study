package com.hhh.study.力扣;

public class _861_翻转矩阵后的得分 {

    public static void main(String[] args) {

        int[][] arr = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore2(arr));

    }


    public static int matrixScore(int[][] A) {

        if (A == null){
            return 0;
        }
        int result = 0;

        for (int[] a : A){
            if (a[0] == 0){
                for (int i = 0; i < a.length; i++){
                    a[i] ^= 1;
                }
            }
        }

        for (int i = 1; i < A[0].length; i++){

            int temp = 0;
            for (int j = 0; j < A.length; j++){
                temp += A[j][i];
            }
            if (temp < (A.length + 1) / 2){
                for (int j = 0; j < A.length; j++){
                    A[j][i] ^= 1;
                }
            }
        }

        for (int i = 0; i < A.length; i++){
            int temp = 0;
            for (int j = A[i].length-1; j >= 0; j--){
                temp += (1 << A[i].length-1-j) * A[i][j];
            }
            result += temp;
        }
        return result;
    }



    public static int matrixScore2(int[][] A) {

        if (A == null){
            return 0;
        }
        int result = 0;

        for (int[] a : A){
            if (a[0] == 0){
                for (int i = 0; i < a.length; i++){
                    a[i] ^= 1;
                }
            }
        }
        result += (1 << (A[0].length-1)) * A.length;

        for (int i = 1; i < A[0].length; i++){

            int temp = 0;
            for (int j = 0; j < A.length; j++){
                temp += A[j][i];
            }
            result += (1 << (A[0].length - 1 - i)) * (temp < (A.length+1)/2 ? A.length - temp : temp);
        }


        return result;
    }
}
