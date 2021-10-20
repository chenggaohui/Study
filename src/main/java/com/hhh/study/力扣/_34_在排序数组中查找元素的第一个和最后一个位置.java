package com.hhh.study.力扣;

import java.util.Arrays;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {

        int[] arr = {1,3,3,3,3,3,5,5,5,7,9};
        int target = 4;
        System.out.println(Arrays.toString(searchRange(arr,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums == null || nums.length<=0){
            return result;
        }
        int index = recursionBinarySearch(nums, target);
        if (index == -1){
            return result;
        }
        int min = index,max = index;
        while(true){
            if(min>0 && nums[min-1] == nums[min]){
                min--;
            }else{
                result[0] = min;
                break;
            }
        }

        while(true){
            if(max<nums.length-1 && nums[max+1] == nums[max]){
                max++;
            }else{
                result[1] = max;
                break;
            }
        }
        return result;

    }

    public static int search(int[] nums, int target,int left,int right){
        if (target<nums[left] || target>nums[right] || left>right){
            return -1;
        }


        int centre = (left+right)/2;


        if (nums[centre] > target){
            return search(nums,target,left,centre-1);
        }else if (nums[centre] < target){
            return search(nums,target,centre+1,right);
        }else{
            return centre;
        }
    }

    public static int recursionBinarySearch(int[] arr,int key){

        int center = -1;
        int start = 0,end = arr.length-1;
        while(start <= end){
            center = (start + end) /2;
            if (arr[center] > key){
                end = center-1;
            }else if (arr[center] < key){
                start = center+1;
            }else{
                return center;
            }
        }

        return -1;
    }
}
