package com.hhh.study.力扣;

public class _697_数组的度 {

    public static void main(String[] args) {

        int[] arr = {1,2,2,3,1,4,2};

        System.out.println(findShortestSubArray(arr));

    }


    public static int findShortestSubArray(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i : nums){
            min = min < i ? min : i;
            max = max > i ? max : i;
        }

        int[] count = new int[max-min+1];
        int[] leftIndex = new int[max-min+1];
        int[] rightIndex = new int[max-min+1];

        int maxCount = 0;
        for (int i  = 0; i < nums.length; i++){
            int index = nums[i] - min;
            count[index]++;
            maxCount = maxCount > count[index] ? maxCount : count[index];
            leftIndex[index] = leftIndex[index] == 0 ? i : leftIndex[index];
            rightIndex[index] = i;
        }
        leftIndex[nums[0]-min] = 0;

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++){
            if (count[i] == maxCount){
                int tempLength = rightIndex[i] - leftIndex[i] + 1;
                minLength = minLength < tempLength ? minLength : tempLength;
            }
        }
        return minLength;
    }
}
