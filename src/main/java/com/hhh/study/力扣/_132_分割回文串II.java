package com.hhh.study.力扣;

import java.util.HashMap;
import java.util.Map;

public class _132_分割回文串II {


    public static void main(String[] args) {

        String str = "abccb";
        System.out.println(minCut(str));
    }


    public static int minCut(String s) {


        return subString(s,0,s.length()-1);

    }

    public static int strHash(String str,int leftIndex,int rightIndex){

        int hash = 0;
        for (;leftIndex <= rightIndex; leftIndex++){

            hash = str.charAt(leftIndex) * 31 + hash;
        }
        return hash;
    }

    public static int strHash2(String str,int leftIndex,int rightIndex){

        int hash = 0;
        for (;leftIndex <= rightIndex; rightIndex--){

            hash = str.charAt(rightIndex) * 31 + hash;
        }
        return hash;
    }

    public static int subString(String str,int left,int right){

        if (left >= right){
            return 0;
        }

        int centerIndex = (left + right) / 2;

        int minNum = Math.min(centerIndex - left,right - centerIndex);
        int size = 0;
        int leftOffset = 0,rightOffset = 1;
        for (int i = 0; i < minNum && centerIndex - i - leftOffset >= 0 && centerIndex + i + rightOffset <= right;i++){
            if (str.charAt(centerIndex - i - leftOffset) == str.charAt(centerIndex + i + rightOffset)){
                size++;
                continue;
            }
            if ((i == 0 && str.charAt(centerIndex - i - 1) != str.charAt(centerIndex + i + 1))){
                leftOffset = 1;
                size++;
                continue;
            }
            if ((i == 0 && str.charAt(centerIndex - i) != str.charAt(centerIndex + i + 2))){
                rightOffset = 2;
                size++;
                continue;
            }
            break;
        }

        return subString(str,left,centerIndex - size) + subString(str,centerIndex + size + 1,right) + 2;

    }

}
