package com.hhh.study.力扣;

public class _746_使用最小花费爬楼梯 {

    public static void main(String[] args) {

        int[] arr = {0,1,2,2};
        System.out.println(minCostClimbingStairs(arr));
    }



    public static int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length <= 1){
            return 0;
        }

        int[] dp = new int[cost.length+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++){


            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }

        return dp[dp.length-1];

    }

}
