package com.hhh.study.力扣;

public class _387_字符串中的第一个唯一字符 {


    public static void main(String[] args) {

//        String s = "cc";
//        System.out.println(firstUniqChar(s));
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }


    public static int firstUniqChar(String s) {

        if (s == null || s.length() == 0){
            return -1;
        }
        if (s.length() == 1){
            return 0;
        }
        int[] count = new int[26];
        for (int i = s.length()-1; i >= 0; i--){
            count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length();i++){
            if (count[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static int singleNumber(int[] nums){

        if (nums == null || nums.length == 0){
            return -1;
        }

        int result = 1;

        for (int i : nums){
            result ^= i;
        }
        return result ^=1;

    }
}
