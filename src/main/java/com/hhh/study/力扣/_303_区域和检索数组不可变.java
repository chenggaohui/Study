package com.hhh.study.力扣;

public class _303_区域和检索数组不可变 {

    public static void main(String[] args) {

    }

    int[] nums = null;

    public _303_区域和检索数组不可变(int[] nums) {

        int length = nums.length;
        this.nums = new int[length];
        if (length > 0){
            this.nums[0] = nums[0];

            for (int i = 1; i < length; i++){
                this.nums[i] = this.nums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {

        if (nums == null ||i > j || i < 0 || j >= nums.length){
            return 0;
        }
        return i == 0 ? nums[j] : (nums[j] - nums[i - 1]);
    }

}
