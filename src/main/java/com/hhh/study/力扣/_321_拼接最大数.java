package com.hhh.study.力扣;

import java.util.Arrays;

public class _321_拼接最大数 {

    public static void main(String[] args) {

        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};

    }

//    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        if (nums1 == null){
//            nums1 = new int[0];
//        }
//        if (nums2 == null){
//            nums2 = new int[0];
//        }
//        int[] total = new int[nums1.length + nums2.length];
//        int index1 = 0,index2 = 0,indexValue;
//        for (int i = 0;i < total.length; i++){
//            if (index1 >= nums1.length-1){
//
//            }
//        }
//        int[] tempNums1 = new int[nums1.length > k ? k : nums1.length];
//        int[] tempNums2 = new int[nums2.length > k ? k : nums2.length];
//
//        for (int i = 0; i < tempNums1.length; i++){
//            tempNums1[tempNums1.length-1-i] = nums1[nums1.length-1-i];
//        }
//        for (int i = nums1.length - tempNums1.length-1; i >= 0; i--){
//            int temp = nums1[i];
//            for (int j = 0; j < tempNums1.length && temp >= tempNums1[j]; j++){
//                tempNums1[j] = tempNums1[j] ^ temp;
//                temp = tempNums1[j] ^ temp;
//                tempNums1[j] = tempNums1[j] ^ temp;
//            }
//        }
//        for (int i = 0; i < tempNums2.length; i++){
//            tempNums2[tempNums2.length-1-i] = nums2[nums2.length-1-i];
//        }
//        for (int i = nums2.length - tempNums2.length-1; i >= 0; i--){
//            int temp = nums2[i];
//            for (int j = 0; j < tempNums2.length && temp >= tempNums2[j]; j++){
//                tempNums2[j] = tempNums2[j] ^ temp;
//                temp = tempNums2[j] ^ temp;
//                tempNums2[j] = tempNums2[j] ^ temp;
//            }
//        }
//
//        return null;
//
//    }
//
//    public static int[] maxNumber2(int[] nums1, int[] nums2, int k) {
//        if (nums1 == null){
//            nums1 = new int[0];
//        }
//        if (nums2 == null){
//            nums2 = new int[0];
//        }
//        int[] total = new int[nums1.length + nums2.length];
//        int index1 = 0,index2 = 0,indexValue;
//        for (int i = 0;i < total.length; i++){
//            if (index1 >= nums1.length){
//                for (int j = i; j < total.length; j++){
//                    total[j] = nums2[index2++];
//                }
//                break;
//            }
//
//            if (index2 >= nums2.length){
//                for (int j = i; j < total.length; j++){
//                    total[j] = nums1[index1++];
//                }
//                break;
//            }
//            if (nums1[index1] >= nums2[index2]){
//                total[i] = nums1[index1++];
//            }else{
//                total[i] = nums2[index2++];
//            }
//
//        }
//
//        System.out.println("~~~~"+Arrays.toString(total));
//        int[] result = new int[k];
//        for (int i = 0; i < result.length; i++){
//            result[result.length-1-i] = total[total.length-1-i];
//        }
//        for (int i = total.length - result.length-1; i >= 0; i--){
//            int temp = total[i];
//            for (int j = 0; j < result.length && temp >= result[j]; j++){
//                result[j] = result[j] ^ temp;
//                temp = result[j] ^ temp;
//                result[j] = result[j] ^ temp;
//            }
//        }
//        return result;
//    }
}
