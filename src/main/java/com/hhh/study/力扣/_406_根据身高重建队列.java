package com.hhh.study.力扣;

import java.util.*;

public class _406_根据身高重建队列 {

    public static void main(String[] args) {
        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints = reconstructQueue(arr);

    }


    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new LinkedList<>();

        for (int[] i : people){
            list.add(i[1],i);
        }

        return list.toArray(new int[people.length][2]);

    }
}
