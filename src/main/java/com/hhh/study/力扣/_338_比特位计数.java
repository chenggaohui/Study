package com.hhh.study.力扣;

import java.util.Arrays;

public class _338_比特位计数 {

    public static void main(String[] args) {

        int[] ints = countBits(16);
        System.out.println(Arrays.toString(ints));

    }


    public static int[] countBits(int num) {

        int[] result = new int[num + 1];

        if (num > 3){
            result[1] = 1;
            result[2] = 1;
            result[3] = 2;
        }else{
            switch (num){
                case 1: result[1] = 1;break;
                case 2: result[1] = 1;result[2] = 1;break;
                case 3: result[1] = 1;result[2] = 1; result[3] = 2;break;
            }
            return result;
        }
        int tempCount = 4;
        int count = 4;

        for (int i = 4; i <= num;){
            int temp = tempCount;
            tempCount += count;
            for (; i < tempCount && i <= num; i++){
                result[i] = result[i - temp] + 1;
            }
            count += temp;
        }
        return result;
    }
}
