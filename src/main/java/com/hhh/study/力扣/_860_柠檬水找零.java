package com.hhh.study.力扣;

public class _860_柠檬水找零 {

    public static void main(String[] args) {
        int[] arr = {5,5,10,10,20};
        System.out.println(lemonadeChange(arr));
    }


    public static boolean lemonadeChange(int[] bills) {

        if (bills == null || bills.length == 0){
            return true;
        }

        int[] record = new int[21];

        for (int i : bills){
            record[i] += 1;
            switch (i){
                case 5: break;
                case 10: if (record[5] >= 1){record[5] -= 1;}else{return false;} break;
                case 20: if (record[10] >= 1 && record[5] >= 1){record[10] -= 1;record[5] -= 1;}else if (record[5] >= 3){record[5] -= 3;}else {return false;} break;
                default: return false;
            }
        }
        return true;
    }
}
