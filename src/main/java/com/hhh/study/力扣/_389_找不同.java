package com.hhh.study.力扣;

public class _389_找不同 {


    public static void main(String[] args) {

        String s = "ae";
        String t = "aea";
        System.out.println(findTheDifference2(s,t));
    }


    public static char findTheDifference(String s, String t) {

        if (s == null || s.length() == 0){
            return t == null ? null : t.charAt(0);
        }

        int[] record = new int[26];

        for (char c : s.toCharArray()){
            record[c-'a'] += 1;
        }

        for (char c : t.toCharArray()){
            record[c-'a'] -= 1;
            if (record[c-'a'] < 0){
                return c;
            }
        }
        return t.charAt(0);

    }


    public static char findTheDifference2(String s, String t) {

        int result = 1;
        for (char c : s.toCharArray()){
            result ^= c;
        }
        for (char c : t.toCharArray()){
            result ^= c;
        }
        return (char)(result ^= 1);

    }
}
