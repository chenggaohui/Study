package com.hhh.study.力扣;

public class _659_分割数组为连续子序列 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,3,4,5};
        System.out.println(isPossible(arr));

    }


    public static boolean isPossible(int[] nums) {
//        if (nums == null || nums.length < 3){
//            return false;
//        }
//
//        int pre = nums[0];
////        int tempSize = 1;
//        int tempMaxCount = 1;
//        int tempMaxCountSize = 0;
//        int tempThisCount = 1;
//        for (int i  = 1; i < nums.length; i++){
//
//            if (nums[i] == pre){
//                tempThisCount++;
//                if (tempThisCount > tempMaxCount){
//                    tempMaxCount = tempThisCount;
//                    tempMaxCountSize = 0;
//                }
//            }else if (nums[i] == pre +1){
//                if (tempThisCount == tempMaxCount){
//                    tempMaxCountSize++;
//                }else if (tempThisCount > tempMaxCount){
//                    tempMaxCount = tempThisCount;
//                    tempMaxCountSize = 0;
//                }
////                tempSize++;
//                pre = nums[i];
//                tempThisCount = 1;
//            }else{
//                if (tempThisCount == tempMaxCount){
//                    tempMaxCountSize++;
//                }else if (tempThisCount > tempMaxCount){
//                    tempMaxCount = tempThisCount;
//                    tempMaxCountSize = 0;
//                }
//                if (tempMaxCountSize < 3){
//                    return false;
//                }
//                pre = nums[i];
//                tempMaxCount = 1;
//                tempMaxCountSize = 0;
//                tempThisCount = 1;
//            }
//
//        }
//        return tempMaxCountSize >= 3;
        return false;
    }

}
