package com.hhh.study.力扣;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _88_合并两个有序数组 {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        merge2(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));

    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        if (nums1 == null || nums1.length<=0 || nums2 == null || nums2.length<=0){
//            return;
//        }
//        for (int i = 0; i < m; i++){
//            if (nums1[i] > nums2[0]){
//                nums1[i] = nums1[i] ^ nums2[0];
//                nums2[0] = nums1[i] ^ nums2[0];
//                nums1[i] = nums1[i] ^ nums2[0];
//                for (int j = 1; j < n && nums2[j-1] > nums2[j]; j++){
//
//                    nums2[j-1] = nums2[j-1] ^ nums2[j];
//                    nums2[j] = nums2[j-1] ^ nums2[j];
//                    nums2[j-1] = nums2[j-1] ^ nums2[j];
//                }
//            }
//        }
//
//        for (int i = m; i < m + n; i++){
//            nums1[i] = nums2[i-m];
//        }
//
//    }
//
//    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
//
//        if (nums1 == null || nums1.length<=0 || nums2 == null || nums2.length<=0){
//            return;
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        int mm = 0,nn = 0;
//        for (int i = 0; i < m + n; i++){
//            if (mm == m){
//                for (int j = nn; nn < n; nn++){
//                    queue.add(nums2[nn]);
//                }
//                break;
//            }
//
//            if (nn == n){
//                for (int j = mm; mm < m; mm++){
//                    queue.add(nums1[mm]);
//                }
//                break;
//            }
//            if (nums1[mm] <= nums2[nn]){
//                queue.add(nums1[mm++]);
//            }else{
//                queue.add(nums2[nn++]);
//            }
//        }
//
//        for (int i = 0; i < m + n; i++){
//            nums1[i]  = queue.poll();
//        }
//
//    }
}
