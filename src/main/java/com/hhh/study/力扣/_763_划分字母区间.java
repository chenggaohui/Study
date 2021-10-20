package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.List;

public class _763_划分字母区间 {

    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] record = new int[26];
        char[] charArray = S.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            char c = charArray[i];
            record[c-'a'] = i;
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < charArray.length; i++){
            int maxIndex = record[charArray[i] - 'a'];
            if (right >= i){
                right = right >= maxIndex ? right : maxIndex;
            }
            if (i > right){
                result.add(right-left+1);
                right = record[charArray[i]-'a'];
                left=i;
            }
        }
        result.add(right-left+1);

        return result;

    }
}
