package com.hhh.study.力扣;

import java.util.*;

public class N个数中M个数相加和为X {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,3,5,6,7,8,9,5,1,2,3,6,3};
        int value = 5;
        List<Integer[]> result = getResult(nums,value);
        System.out.println("个数：" + result.size());

        result.stream().forEach(e->{
            System.out.println(Arrays.toString(e));
        });
    }


    public static List<Integer[]> getResult(int[] nums,int value){
        if (nums == null) return new ArrayList<>();

        Map<Integer,List<List<Integer>>> record = new HashMap<>();
        Map<Integer,List<List<Integer>>> tempRecord = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){

            int finalI = i;
            for (Map.Entry<Integer,List<List<Integer>>> entry : record.entrySet()){
                if (nums[i] + entry.getKey() > value){
                    continue;
                }
                if (nums[i] + entry.getKey() == value){
                    List<List<Integer>> lists = entry.getValue();

                    lists.stream().forEach(e->{
                        Integer[] arr = new Integer[e.size() + 1];
                        e.toArray(arr);
                        arr[arr.length-1] = nums[finalI];
                        result.add(arr);
                    });

//                    Integer[] arr = new Integer[entry.getValue().size() + 1];
//                    entry.getValue().toArray(arr);
//                    arr[arr.length-1] = nums[i];
//                    result.add(arr);
//                    continue;
                }
                int key = nums[i] + entry.getKey();
                tempRecord.put(key,new ArrayList(entry.getValue()));
                tempRecord.get(key).forEach(e->{e.add(nums[finalI]);});
            }
            tempRecord.put(nums[i],new ArrayList<>());
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(nums[i]);
            tempRecord.get(nums[i]).add(objects);
            for (Map.Entry<Integer,List<List<Integer>>> entry : tempRecord.entrySet()){
                if (!record.containsKey(entry.getKey())){
                    record.put(entry.getKey(),new ArrayList<>());
                }

                entry.getValue().forEach(e->{
                    record.get(entry.getKey()).add(e);
                });


            }
            tempRecord.clear();


        }

        return result;

    }
}
