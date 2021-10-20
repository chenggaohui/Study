package com.hhh.study.力扣;

import java.util.Arrays;
import java.util.Comparator;

public class _1353_最多可以参加的会议数目 {

    public static void main(String[] args) {
//        int[][] arr = {{1,5},{1,5},{1,5},{2,3},{2,3}};
//        int[][] arr = {{1,2},{1,2},{3,3},{1,5},{1,5}};
        int[][] arr = {{1,2},{2,3},{3,4},{1,2}};
//        int[][] arr = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] arr = {{1,3},{1,3},{1,3},{3,4}};
        System.out.println(maxEvents(arr));
    }



    public static int maxEvents(int[][] events) {

//        if (events == null || events.length == 0){
//            return 0;
//        }
//        if (events.length == 1){
//            return 1;
//        }
//
//        Arrays.sort(events, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int length1 = o1[1] - o1[0];
//                int length2 = o2[1] - o2[0];
//                return length1 == length2 ? o1[0] - o2[0] : length1 - length2;
//            }
//        });
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int[] i : events){
//            min = min > i[0] ? i[0] : min;
//            max = max < i[1] ? i[1] : max;
//        }
//
//        int[] arr = new int[max-min + 1];
//
//        int count = 0;
//        for (int i = 0; i < events.length; i++){
//            for (int j = events[i][1]; j >= events[i][0]; j--){
//                if (arr[j-min] == 0){
//                    arr[j-min]++;
//                    count++;
//                    break;
//                }
//            }
//        }
//        return count;
        return -1;


    }
}
