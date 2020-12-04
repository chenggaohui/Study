package com.hhh.study.力扣;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class _32_最长有效括号 {

    public static void main(String[] args) {

        String str = "(()";
        System.out.println(longestValidParentheses(str));

        List<String> list  =new ArrayList<>();
    }


    public static int longestValidParentheses(String s) {

        int maxLength = 0;
        if (s == null || s.length() <= 1){
            return maxLength;
        }

        int surplus = 0;
        int temp = 0;
        for (char c : s.toCharArray()){

            if (c == '('){
                surplus++;
                continue;
            }
            if (c == ')' && surplus > 0){
                surplus--;
                temp += 2;
                if (surplus == 0){
                    maxLength = maxLength > temp ? maxLength :temp;
                }
                continue;
            }

            maxLength = maxLength > temp ? maxLength :temp;
            temp = 0;
            surplus = 0;
        }
        if (surplus == 0){
            maxLength = maxLength > temp ? maxLength :temp;
        }


        return maxLength;

    }

}
