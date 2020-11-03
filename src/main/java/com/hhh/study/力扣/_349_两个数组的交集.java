package com.hhh.study.力扣;

import java.util.*;

public class _349_两个数组的交集 {

    public static void main(String[] args) {

        int arr1[] = {1,2,2,1};

        int arr2[] = {2,2};

        int[] intersection = intersection(arr1, arr2);
        for (int i : intersection){
            System.out.print(i+",");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        if (nums1.length <= nums2.length){
            for (int i : nums1){
                set.add(i);
            }
            for (int i : nums2){
                if (set.contains(i)){
                    result.add(i);
                }
            }
        }else{
            for (int i : nums2){
                set.add(i);
            }
            for (int i : nums1){
                if (set.contains(i)){
                    result.add(i);
                }
            }
        }

        int[] arr = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        int index = 0;
        while (iterator.hasNext()){
            arr[index] = iterator.next();
            index++;
        }
        return arr;

    }

}
