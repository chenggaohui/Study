package com.hhh.study.力扣;

public class _767_重构字符串 {

    public static void main(String[] args) {

        System.out.println(reorganizeString("abbabba"));
    }



    public static String reorganizeString(String S) {

        if (S==null||S.length()<=1){
            return "";
        }

        int[] count = new int[26];
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0;i<S.length();i++){
            int index = S.charAt(i) - 'a';
            count[index] += 1;
            if(count[index] > maxCount){
                maxCount = count[index];
                maxIndex = index;
            }
        }
        count[maxIndex] = 0;

        if (maxCount >= (S.length()+1)/2+1){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCount; i++){
            sb.append((char)(maxIndex+'a'));
        }
        int nextIndex = 1;
        for (int i = 0;i<26;i++){
            for (int j = 0;j<count[i];j++){
                if (nextIndex> sb.length()){
                    nextIndex = 1;
                }
                sb.insert(nextIndex,(char)(i+'a'));
                nextIndex+=2;
            }
        }

        return sb.toString();
    }
}
