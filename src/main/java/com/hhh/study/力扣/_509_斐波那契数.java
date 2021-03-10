package com.hhh.study.力扣;

public class _509_斐波那契数 {


    public static void main(String[] args) {

        System.out.println(fib(4));
    }


    public static int fib(int n) {

        if (n <= 1){
            return n;
        }

        int left = 0;
        int right = 1;

        for (int i = 2; i < n;){
            left += right;
            if (++i >= n){
                break;
            }
            right += left;
            i++;
        }
        return left + right;
    }
}
