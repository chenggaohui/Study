package com.hhh.study.力扣;

import java.util.Arrays;

public class _354_俄罗斯套娃信封问题 {

    public static void main(String[] args) {

//        int[][] arr = {{5,4},{6,7},{6,4},{2,3}};
//        int[][] arr = {{1,1},{1,1},{1,1}};
//        int[][] arr = {{2,100},{3,200},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};

//        int[][] arr = {{2,100},{3,200},{4,300},{5,400},{5,250},{6,370},{6,360},{7,380}};
        int[][] arr = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(maxEnvelopes(arr));

    }

    public static int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null){
            return 0;
        }
        if (envelopes.length <= 1){
            return envelopes.length;
        }
        quickSort3(envelopes,0,envelopes.length-1);

        int result = 0;
        int w = 0,h = 0;
        for (int i = 0; i < envelopes.length; i++){
            if (envelopes[i][0] > w && envelopes[i][1] > h){
                result++;
                w = envelopes[i][0];
                h = envelopes[i][1];
            }
        }

//        quickSort(envelopes,0,envelopes.length-1,1,0);
//
//        int result2 = 0;
//        int w1 = 0,h1 = 0;
//        for (int i = 0; i < envelopes.length; i++){
//            if (envelopes[i][0] > w1 && envelopes[i][1] > h1){
//                result2++;
//                w1 = envelopes[i][0];
//                h1 = envelopes[i][1];
//            }
//        }

        return result;

    }

    public static void quickSort(int[][] arr,int left,int right,int comapre1,int compare2){
        if (left >= right) return;

        int i = left,j = right;
        int index = left;

        while(i < j){
            while (i < j && (arr[j][comapre1] > arr[index][comapre1] || (arr[j][comapre1] == arr[index][comapre1] && arr[j][compare2] >= arr[index][compare2]))){
                j--;
            }
            while(i < j && (arr[i][comapre1] < arr[index][comapre1] || (arr[i][comapre1] == arr[index][comapre1] && arr[i][compare2] <= arr[index][compare2]))){
                i++;
            }
            if (i < j){
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int[] temp = arr[j];
        arr[j] = arr[index];
        arr[index] = temp;

        quickSort(arr,left,j - 1,comapre1,compare2);
        quickSort(arr,j + 1,right,comapre1,compare2);
    }


    public static void quickSort3(int[][] arr,int left,int right){
        if (left >= right) return;

        int i = left,j = right;
        int index = left;
        int indexCount = arr[index][0] | arr[index][1];

        while(i < j){
            while (i < j && ((arr[j][0] | arr[j][1]) >= indexCount)){
                j--;
            }
            while (i < j && ((arr[i][0] | arr[i][1]) <= indexCount)){
                i++;
            }
            if (i < j){
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int[] temp = arr[j];
        arr[j] = arr[index];
        arr[index] = temp;

        quickSort3(arr,left,j - 1);
        quickSort3(arr,j + 1,right);
    }


}
