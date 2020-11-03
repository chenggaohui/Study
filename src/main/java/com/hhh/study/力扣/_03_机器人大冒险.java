package com.hhh.study.力扣;


import sun.security.util.BitArray;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _03_机器人大冒险 {

    public static void main(String[] args) {
        int[][] arr = {{10, 5}, {1, 6}, {6, 10}, {3, 0}, {0, 3}, {0, 10}, {6, 2}};

        System.out.println(robot2("RUUR",arr,7856,9033));
    }

    public static boolean robot2(String command, int[][] obstacles, int x, int y) {
        long result = 1;


        for (int i = 0; i < x; i++){
            result <<= 1;
            result |= 1;
            result %= Long.MAX_VALUE;
        }
        for (int j = 0; j < y; j++){
            result <<= 1;
            result %= Long.MAX_VALUE;
        }

        System.out.println("终点："+result);

        Set<Long> set = new HashSet<>();

        long temp = 1;
        for (int i = 0; i < obstacles.length; i++){

            temp = 1;
            for (int j = 0; j < obstacles[i].length; j++){

                if (j % 2 == 0){
                    for (int n = 0; n < obstacles[i][j]; n++){
                        temp <<= 1;
                        temp |= 1;
                        temp %= Long.MAX_VALUE;
                    }
                }else{
                    for (int m = 0; m < obstacles[i][j]; m++){
                        temp <<= 1;
                        temp %= Long.MAX_VALUE;
                    }
                }
            }
            System.out.println("障碍物："+temp);
            set.add(temp);
        }

        long wayX = 0, wayY = 0, way = 1;

        char[] chars = command.toCharArray();
        while (way != result){
            if (set.contains(way)){
                return false;
            }
            for (char c : chars){
                way = 1;
                if (c == 'U'){
                    wayY++;
                }else{
                    wayX++;
                }
                for (int i = 0; i < wayX; i++){
                    way <<= 1;
                    way |= 1;
                    way %= Long.MAX_VALUE;
                }
                for (int j = 0; j < wayY; j++){
                    way <<= 1;
                    way %= Long.MAX_VALUE;
                }

                if (set.contains(way)){
                    System.out.println(way);
                    return false;
                }
                if (way == result){
                    return true;
                }
            }
            System.out.println("一轮结束："+way);
        }
        return true;
    }



    public static boolean robot(String command, int[][] obstacles, int x, int y) {

        BitArray result = new BitArray(x+y);

        int resultX = 0;
        int resultY = 0;
        for (; resultX < x; resultX++){
            result.set(resultX,true);
        }
        for (; resultY < y; resultY++){
            result.set(resultX+resultY,false);
        }

        System.out.println("终点："+result.toString());

        Set<String> set = new HashSet<>();

        BitArray bitTemp = null;
        for (int i = 0; i < obstacles.length; i++){

            bitTemp = new BitArray(obstacles[i][0]+obstacles[i][1]);
            int temp = 0;
            for (int j = 0; j < obstacles[i].length; j++){

                if (j % 2 == 0){
                    for (int n = 0; n < obstacles[i][j]; n++){
                        bitTemp.set(temp,true);
                        temp++;
                    }
                }else{
                    for (int m = 0; m < obstacles[i][j]; m++){
                        bitTemp.set(temp,false);
                        temp++;
                    }
                }
            }
            System.out.println("障碍物："+temp);
            set.add(bitTemp.toString());
        }

        int wayX = 0, wayY = 0;
        BitArray way = new BitArray(0);

        char[] chars = command.toCharArray();
        while (way.toString() != result.toString()){
            if (set.contains(way)){
                return false;
            }
            for (char c : chars){
                way = new BitArray(wayX+wayY+1);
                if (c == 'U'){
                    wayY++;
                }else{
                    wayX++;
                }
                int ii = 0;
                for (; ii < wayX; ii++){
                    way.set(ii,true);
                }
                for (int j = 0; j < wayY; j++){
                    way.set(ii+j,false);
                }

                if (set.contains(way.toString())){
                    System.out.println(way.toBooleanArray());
                    return false;
                }
                if (way.toString() == result.toString()){
                    return true;
                }
            }
            System.out.println("一轮结束："+way.toString());
        }
        return true;
    }
}