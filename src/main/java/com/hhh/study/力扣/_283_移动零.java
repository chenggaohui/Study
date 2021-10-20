package com.hhh.study.力扣;

import java.util.Arrays;

public class _283_移动零 {
    public static void main(String[] args) {
        int[] i = {0,1,0,3,12};
        moveZeroes(i);
        System.out.println(Arrays.toString(i));

    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length<=1){
            return;
        }
        int swapIndex = -1;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == 0 && swapIndex < 0){
                swapIndex = i;
                continue;
            }
            if (nums[i] != 0 && swapIndex >= 0){
                nums[i] = nums[i] ^ nums[swapIndex];
                nums[swapIndex] = nums[i] ^ nums[swapIndex];
                nums[i] = nums[i] ^ nums[swapIndex];
                swapIndex++;
            }

        }
    }
}
