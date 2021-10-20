package com.hhh.study.力扣;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_独一无二的出现次数 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));

    }


    public static boolean uniqueOccurrences(int[] arr) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i : arr){
                if (map.containsKey(i)){

                    map.put(i,map.get(i)+1);
                    continue;
                }
                map.put(i,1);
            }

            Set<Integer> set = new HashSet<>();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                set.add(entry.getValue());
            }
            int count = 0;
            for (int i : set){
                count += i;
            }
            return count == arr.length;

    }
}
