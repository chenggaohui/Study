package com.hhh.study.力扣;

public class _300_最长上升子序列 {

    public static void main(String[] args) {

    }


    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length <= 1){
            return nums == null ? 0 : nums.length;
        }

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){

            }
        }
        return -1;
    }
}
