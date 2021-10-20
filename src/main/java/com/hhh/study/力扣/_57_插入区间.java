package com.hhh.study.力扣;

public class _57_插入区间 {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{6,9}};
        int[] newArr = {2,5};
        int[][] insert = insert(arr, newArr);

        for (int i = 0; i<insert.length;i++){
            for (int j = 0; j<insert[i].length;j++){
                System.out.print(insert[i][j]+",");
            }
            System.out.println("");
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (newInterval == null || intervals == null){
            return intervals;
        }
        int[][] result = new int[intervals.length][];
        int min = newInterval[0];
        int max = newInterval[newInterval.length-1];
        int index = 0;
        for (int i = 0; i < intervals.length; i++){
            int tempMin = intervals[i][0];
            int tempMax = intervals[i][intervals[i].length-1];
            if (tempMax<min||tempMin>max || (tempMin >= min && tempMax >= max)){
                result[index] = intervals[i];
                index++;
            }else{
                if (tempMin>min&&tempMax<max){
                    continue;
                }
                if (tempMin<min) {
                    if (result[index] != null && result[index][1]==0){
                        result[index][1] = max;
                        index++;
                    }
                    int[] arr = new int[2];
                    arr[0] = tempMin < min ? tempMin : min;
                    result[index] = arr;
                }
                if(tempMax>max) {
                    result[index][1] = tempMax > max ? tempMax : max;
                    index++;
                }
            }

        }
        return result;
    }
}
