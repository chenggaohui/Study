package com.hhh.study.力扣;

import org.springframework.util.CollectionUtils;

public class _665_非递减数列 {

    public static void main(String[] args) {

        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {

        if (nums == null || nums.length < 1){
            return false;
        }
        if (nums.length == 1){
            return true;
        }

        boolean sign = true;

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i-1] <= nums[i]) continue;
            sign = !sign;
            if (sign){
                return false;
            }
            if (nums[i+1] < nums[i] || nums[i+1] < nums[i-1]){
                return false;
            }

        }

        return true;

    }

    public boolean checkPossibility2(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

}
