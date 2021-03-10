package com.hhh.study.力扣;

import java.util.Arrays;

public class _188_买卖股票的最佳时机IV {

    public static void main(String[] args) {

        int[] arr = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k,arr));
    }


    public static int maxProfit(int k, int[] prices) {

        int result = 0;
//        if (prices == null || k == 0 || prices.length == 0){
//            return result;
//        }
//        int length = prices.length;
//        int[][] record = new int[length][2];
//        record[0][1] = -prices[0];
//
//        for (int i = 1; i < length; i++){
//
//            record[i][0] = Math.max(record[i-1][0],record[i-1][1]+prices[i]);
//            record[i][1] = Math.max(record[i-1][0]-prices[i],record[i-1][1]);
//        }
//        int[] diff = new int[length];
//        for (int i = 1; i < length; i++){
//            diff[i] = record[i][0]-record[i-1][0];
//        }
//
//        Arrays.sort(diff);
//        for (int i = length-1; i > length-1-k; i--){
//            result += diff[i];
//        }
        return result;
    }
}
