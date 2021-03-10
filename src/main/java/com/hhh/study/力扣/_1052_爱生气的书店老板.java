package com.hhh.study.力扣;

import java.util.Scanner;

public class _1052_爱生气的书店老板 {

    static int[] maxHeap = null;
    static int size = 0;

    public static void main(String[] args) {
//        int[] customers = {2,6,6,9};
//        int[] grumpy = {0,0,1,1};
//        int X = 1;
//        System.out.println(maxSatisfied2(customers,grumpy,X));

        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.hasNext());

    }


    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        if (customers == null || customers.length == 0){
            return 0;
        }

        maxHeap = new int[customers.length];

        int maxConsumers = 0;
        for (int i = 0;i < customers.length; i++){
//            if (grumpy[i] == 0){
//                maxConsumers += customers[i];
//            }else{
//                add(customers[i]);
//            }
            add(customers[i]);
        }

//        while(--X >= 0){
//            maxConsumers += pop();
//        }
//        while (size > 1){
//            System.out.println(pop());
//        }

        return maxConsumers;

    }

    public static void add(int value){
        maxHeap[size] = value;
        up(size);
        size++;
    }

    public static void up(int index){
        int parentIndex = (index - 1) / 2;

        while(parentIndex >= 0){
            if (maxHeap[parentIndex] >= maxHeap[index]){
                return;
            }
            maxHeap[parentIndex] ^= maxHeap[index];
            maxHeap[index] ^= maxHeap[parentIndex];
            maxHeap[parentIndex] ^= maxHeap[index];

            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public static int pop(){
        int rootValue = maxHeap[0];
        maxHeap[0] = maxHeap[size--];
        down(0);
        return rootValue;
    }

    public static void down(int index){

        while(index < size / 2){
            int leftIndex = index << 1 + 1;
            int rightIndex = (index + 1) << 1;

            int maxValueIndex = maxHeap[leftIndex] > maxHeap[rightIndex] ? leftIndex : rightIndex;

            maxHeap[index] ^= maxHeap[maxValueIndex];
            maxHeap[maxValueIndex] ^= maxHeap[index];
            maxHeap[index] ^= maxHeap[maxValueIndex];

            index = maxValueIndex;

        }
    }

    public static int maxSatisfied2(int[] customers, int[] grumpy, int X) {

        if (customers == null || customers.length == 0){
            return 0;
        }


        int maxWindowAngrys = 0,maxLeftIndex = 0,maxRightIndex = X-1;

        for (int i = 0; i <= maxRightIndex; i++){
            if (grumpy[i] == 1){
                maxWindowAngrys += customers[i];
            }
        }

        int tempWindowAngrys = maxWindowAngrys;
        int leftIndex = maxLeftIndex,rightIndex = maxRightIndex;
        for (int i = X; i < customers.length; i++){
            rightIndex = i;
            leftIndex = rightIndex - X + 1;

            if (grumpy[leftIndex-1] == 1){
                tempWindowAngrys -= customers[leftIndex-1];
            }

            if (grumpy[rightIndex] == 1){
                tempWindowAngrys += customers[rightIndex];
            }

            if (tempWindowAngrys > maxWindowAngrys){
                maxWindowAngrys = tempWindowAngrys;
                maxLeftIndex = leftIndex;
                maxRightIndex = rightIndex;
            }

        }
        for (int i = maxLeftIndex; i <= maxRightIndex; i++){
            grumpy[i] = 0;
        }

        int result = 0;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i] == 0){
                result += customers[i];
            }
        }
        return result;
    }
}
