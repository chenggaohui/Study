package com.hhh.study.力扣;


import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class _435_无重叠区间 {

    public static void main(String[] args) {

    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if (intervals == null || intervals.length <= 1){
            return result;
        }

        Arrays.sort(intervals,(l,r)->{return l[0]-r[0];});

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){

            if (intervals[i][0] < end){
                end = Math.min(end,intervals[i][1]);
                result++;
            }else{
                end = intervals[i][1];
            }
        }
        return result;
    }
}
