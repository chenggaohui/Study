package com.hhh.study.力扣;


public class _1356_根据数字二进制下1的数目排序 {

    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] ints = sortByBits(arr);
        for (int i : ints){
            System.out.println(i);
        }


    }

    public static int[] sortByBits(int[] arr) {
        if (arr == null || arr.length<1){
            return arr;
        }

        int[] countBit = new int[arr.length];

        for (int i = 0; i<arr.length; i++){
            int temp = arr[i];
            int count = 0;
            while(temp > 0){
                if ((temp & 1) == 1){
                    count++;
                }
                temp >>=1;
            }
            countBit[i] = count;
        }

        for (int i = 0; i < countBit.length-1; i++){
            for (int j = 0; j<countBit.length-1-i;j++){
                if ((countBit[j] > countBit[j+1]) || (countBit[j] == countBit[j+1] && arr[j]>arr[j+1])){
                    countBit[j] = countBit[j] ^ countBit[j+1];
                    countBit[j+1] = countBit[j] ^ countBit[j+1];
                    countBit[j] = countBit[j]^countBit[j+1];

                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }

            }
        }
        return arr;

    }
}
