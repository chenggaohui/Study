package com.hhh.study.力扣;

public class _714_买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {


        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr,2));
        System.out.println(maxProfit3(arr));
    }



    public static int maxProfit(int[] prices, int fee) {

        int result = 0;
        int buy = prices[0]+fee;

        for (int i = 1; i<prices.length; i++){
            if (prices[i] + fee < buy){
                buy  = prices[i] +fee;
            }else if (prices[i] > buy){
                result += prices[i] -buy;
                buy = prices[i];
            }
        }

        return result;


    }


    public static int maxProfit2(int[] prices, int fee){

       int[][] dp = new int[prices.length][2];
       dp[0][0] = 0;
       dp[0][1] = -prices[0];

       for (int i = 1;i < prices.length;i++){
           dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] -fee);
           dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]);
       }

       return dp[prices.length-1][0];
    }

    public static int maxProfit3(int[] prices){

        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){

            if (min > prices[i]){
                min = prices[i];
                minIndex = i;
            }
        }
        int max = min;

        for (int i = minIndex; i < prices.length; i++){
            max = max > prices[i] ? max : prices[i];
        }
        return max - min;
    }
}
