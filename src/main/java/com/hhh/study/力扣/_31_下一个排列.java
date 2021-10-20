package com.hhh.study.力扣;

import java.util.Arrays;

public class _31_下一个排列 {



    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = {8,6,3,9,4,1,0};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    //使用计数排序法
    public static void nextPermutation1(int[] nums) {
        int[] count = new int[10];
        int length = nums.length;

        for(int i = length-1; i > 0; i--){
            if (nums[i] > nums[i-1]){
                count[nums[i]]++;
                //寻找大于nums[i-1]的数的下标
                for (int m = i; m <= length; m++){
                    if (m == length || nums[m] <= nums[i-1]){
                        count[nums[m-1]]--;
                        count[nums[i-1]]++;
                        nums[m-1] = nums[m-1] ^ nums[i-1];
                        nums[i-1] = nums[m-1] ^ nums[i-1];
                        nums[m-1] = nums[m-1] ^ nums[i-1];
                        break;

                    }
                }

                for (int j = 0;j<count.length;j++){
                    for (int n = 0;n<count[j];n++){
                        nums[i++] = j;
                    }
                }
                return;

            }
            count[nums[i]]++;
        }
        for (int i = 0;i < length/2;i++){
            nums[i] = nums[i] ^ nums[length-1-i];
            nums[length-1-i] = nums[i] ^ nums[length-1-i];
            nums[i] = nums[i] ^ nums[length-1-i];
        }
    }


    public static void nextPermutation(int[] nums) {
        int length = nums.length;

        for(int i = length-1; i > 0; i--){
            if (nums[i] > nums[i-1]){
                //寻找大于nums[i-1]的数的下标
                for (int m = i; m <= length; m++){
                    if (m == length || nums[m] <= nums[i-1]){
                        nums[m-1] = nums[m-1] ^ nums[i-1];
                        nums[i-1] = nums[m-1] ^ nums[i-1];
                        nums[m-1] = nums[m-1] ^ nums[i-1];
                        break;

                    }
                }

                for(int j = 0;j < (length-i)/2;j++){
                    nums[i+j] = nums[i+j] ^ nums[length-1-j];
                    nums[length-1-j] = nums[i+j] ^ nums[length-1-j];
                    nums[i+j] = nums[i+j] ^ nums[length-1-j];
                }
                return;

            }
        }
        for (int i = 0;i < length/2;i++){
            nums[i] = nums[i] ^ nums[length-1-i];
            nums[length-1-i] = nums[i] ^ nums[length-1-i];
            nums[i] = nums[i] ^ nums[length-1-i];
        }
    }
}
