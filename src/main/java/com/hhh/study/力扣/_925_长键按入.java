package com.hhh.study.力扣;

import org.springframework.util.StringUtils;

public class _925_长键按入 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("kikcxmvzi","kiikcxxmmvvzz"));
    }

    public static boolean isLongPressedName(String name, String typed) {

        if(name == null || typed == null){
            return false;
        }

        if (typed.length()<name.length()){
            return false;
        }
        char[] names = name.toCharArray();
        char[] types = typed.toCharArray();

        char sign = ' ';
        int j = 0;
        for(int i = 0; i < names.length; i++,j++){
            if (j >= types.length){
                return false;
            }
            char n = names[i];
            char t = types[j];
            if (n != t){
                while(sign == t){
                    j++;
                    if (j >= types.length){
                        return false;
                    }
                    t = types[j];
                }
            }
            if (n != t){
                return false;
            }

            sign = n;

        }
        if(j < types.length-1){
            for (;j<types.length;j++){
                if (sign != types[j]){
                    return false;
                }
            }
        }
        return true;
    }


}
