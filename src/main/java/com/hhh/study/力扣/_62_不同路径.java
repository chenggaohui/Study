package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.Stack;

public class _62_不同路径 {
    public static void main(String[] args) {

        System.out.println(uniquePaths4(3,7));
    }



    public static int uniquePaths(int m, int n) {

        if (m <= 1 || n <=1 ){
            return 1;
        }

        return search(1,1,m,n,0);
    }

    public static int search(int mm,int nn,int m,int n,int count){
        if (mm == m || nn == n){
            return 1;
        }

        return search(mm + 1,nn,m,n,count+1)+search(mm,nn+1,m,n,count+1);

    }

    public static int uniquePaths2(int m, int n) {

        if (m <= 1 || n <=1 ){
            return 1;
        }
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(m);
        stack.push(n);

        while(!stack.isEmpty()){
            Integer nn = stack.pop();
            Integer mm = stack.pop();
            if (nn == 1 || mm == 1){
                count++;
            }else{
                stack.push(mm);
                stack.push(nn-1);
                stack.push(mm-1);
                stack.push(nn);
            }
        }
        return count;
    }

    public static int uniquePaths3(int m, int n) {

        if (m <= 1 || n <=1 ){
            return 1;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = i - 1 < 0 ? 0 : dp[i -1][j];
                int left = j - 1 < 0 ? 0 : dp[i][j -1];
                int count = up == 0 && left == 0 ? 1 : up + left;
                dp[i][j] = count;
            }
        }
        return dp[n-1][m-1];
    }


    public static int uniquePaths4(int m, int n) {

        if (m <= 1 || n <=1 ){
            return 1;
        }
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = i - 1 < 0 ? 0 : dp[j];
                int left = j - 1 < 0 ? 0 : dp[j -1];
                int count = up == 0 && left == 0 ? 1 : up + left;
                dp[j] = count;
            }
        }
        return dp[m-1];
    }
}
