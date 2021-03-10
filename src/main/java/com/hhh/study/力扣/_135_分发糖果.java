package com.hhh.study.力扣;

public class _135_分发糖果 {

    public static void main(String[] args) {

        int[] arr = {1,2,87,87,87,2,1};
        System.out.println(candy(arr));
        System.out.println(candy2(arr));
    }


    public static int candy(int[] ratings) {


        if (ratings == null || ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }

        int count = 1;
        int preNum = 1;

        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                count += ++preNum;
            }else if (ratings[i] < ratings[i-1] && preNum == 1){
                count += 2;
                preNum = 1;
            }else{
                count += 1;
                preNum = 1;
            }
            System.out.println("发到第："+i+"人的水果总数为："+count);
        }

        return count;
    }


    public static int candy2(int[] ratings) {


        if (ratings == null || ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }

        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                dp[i] = dp[i-1] + 1;
            }else if (ratings[i] < ratings[i-1] && dp[i-1] == 1){
                dp[i] = 1;
                dp[i-1]++;
            }else{
                dp[i] = 1;
            }
        }


        int[] dp2 = new int[ratings.length];
        dp2[dp2.length-1] = 1;
        for (int i = ratings.length-2; i >= 0; i--){
            if (ratings[i] > ratings[i+1]){
                dp2[i] = dp2[i+1] + 1;
            }else if (ratings[i] < ratings[i+1] && dp2[i+1] == 1){
                dp2[i] = 1;
                dp2[i+1]++;
            }else{
                dp2[i] = 1;
            }
        }



        int result = 0;
        for (int i  = 0; i < ratings.length; i++){
            result += dp[i] > dp2[i] ? dp[i] : dp2[i];
        }
        return result;
    }
}
