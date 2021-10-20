package com.hhh.study.力扣;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _134_加油站 {

    public static void main(String[] args) {

        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        System.out.println(canCompleteCircuit(gas,cost));




    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length <= 0 || cost.length <= 0){
            return -1;
        }
        int length = gas.length;
        int start = -1;
        int count = 0;
        boolean sign = true;
        int countGas = 0,countCost = 0;
        for (int i = 0; i < length; i++){
            countGas+=gas[i];
            countCost+=cost[i];
            count += (gas[i] - cost[i]);
            if (count >= 0 && sign){
                start = i;
            }else if (count < 0){
                count = 0;
                start = -1;
                sign = true;
                continue;
            }
            sign = false;

        }
        start = (countGas-countCost) >= 0 ? start : -1;


        return start;


    }
}
