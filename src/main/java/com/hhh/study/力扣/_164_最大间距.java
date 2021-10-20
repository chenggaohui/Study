package com.hhh.study.力扣;

import sun.security.util.BitArray;

public class _164_最大间距 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        System.out.println(maximumGap(arr));

    }


    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums){
            min = i >= min ? min : i;
            max = i <= max ? max : i;
        }
        boolean[] booleans = new boolean[max -min +1];
        for (int i : nums){
            booleans[i - min] =  true;
        }
        int maxDifference = 0;
        int count = 0;
        for (int i = 0; i < booleans.length; i++){
            count++;
            if (booleans[i] == true){
                count = count > 1 ? count : 0;
                maxDifference = maxDifference > count ? maxDifference : count;
                count = 0;
            }
        }
        return maxDifference;
    }

}
