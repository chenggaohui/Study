package com.hhh.study.力扣;

public class _1370_上升下降字符串 {

    public static void main(String[] args) {

        System.out.println(sortString("aaaabbbbcccc"));

    }


    public static String sortString(String s) {
        if (s == null || s.length() <=1){
            return s;
        }

        int[] ints = new int[26];

        for (char c : s.toCharArray()){
            int index = c - 'a';
            ints[index] += 1;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){


            for (int i = 0; i < ints.length; i++){
                if (ints[i] > 0){
                    ints[i] -= 1;
                    sb.append((char)(i + 'a'));
                }
            }

            for (int i = ints.length-1; i >= 0; i--){
                if (ints[i] > 0){
                    ints[i] -= 1;
                    sb.append((char)(i + 'a'));
                }
            }
        }
        return sb.toString();

    }
}
