package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1178_猜字谜 {

    public static void main(String[] args) {

        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        System.out.println(findNumOfValidWords(words,puzzles).toString());


    }


    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0 || puzzles == null || puzzles.length == 0){
            return new ArrayList<>();
        }
        char offset = '`';
        int[][] countPuzz = new int[puzzles.length][27];
        for (int i = 0; i < puzzles.length; i++){
            String str = puzzles[i];
            countPuzz[i][0] = str.charAt(0) - offset;

            for (int j = 0; j < str.length(); j++){
                countPuzz[i][str.charAt(j) - offset] = 1;
            }
        }

        boolean sign = false;
        int[] count = new int[puzzles.length];
        for (int i = 0; i < words.length; i++){

            for (int j = 0; j < countPuzz.length; j++){
                sign = false;
                for (int n = 0; n < words[i].length(); n++){
                    int charAtOffSet = words[i].charAt(n) - offset;
                    if (countPuzz[j][0] == charAtOffSet){
                        sign = true;
                    }
                    if (countPuzz[j][charAtOffSet] == 0){
                        sign = false;
                        break;
                    }
                }
                if (sign){
                    count[j]++;
                }
            }


        }

        Arrays.stream(count).forEach(e->{result.add(e);});
        return result;
    }
}
