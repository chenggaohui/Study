package com.hhh.study.力扣;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1030_距离顺序排列矩阵单元格 {

    public static void main(String[] args) {
        int[][] ints = allCellsDistOrder(3, 3, 0, 2);
        for (int[] i: ints){
            System.out.println(i[0]+","+i[1]);
        }
    }


    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {


        int[][] result = new int[R*C][2];
        result[0] = new int[]{r0,c0};
        int max = Math.max(Math.max(r0,c0),Math.max(R-r0,C-c0));
        int index = 1;
        for (int i = 1; i <= max; i++){
            for (int j = 0; j <= i; j++){

                if (r0 - i >= 0 && c0 + j < C){
                    result[index++] = new int[]{r0 - i,c0 + j};
                    if (index >= result.length){
                        return result;
                    }
                }

                if (j > 0 &&  r0 - i > 0 && c0 + j >= 0){
                    result[index++] = new int[]{r0 - i,c0 - j};
                    if (index >= result.length){
                        return result;
                    }
                }

                if (r0 + j < R && c0 + i < C){

                    result[index++] = new int[]{r0 + j,c0 + i};
                    if (index >= result.length){
                        return result;
                    }
                }
                if (j > 0 && r0 - j > 0 && c0 + i < C){
                    result[index++] = new int[]{r0 - j,c0 + i};
                    if (index >= result.length){
                        return result;
                    }
                }

                if (r0 + i < R && c0 - j >=0){

                    result[index++] = new int[]{r0 + i,c0 - j};
                    if (index >= result.length){
                        return result;
                    }
                }
                if (j > 0 && r0 + i < R && c0 + j < C-1){
                    result[index++] = new int[]{r0 + i,c0 + j};
                    if (index >= result.length){
                        return result;
                    }
                }
                if (r0 - j >= 0 && c0 - i >= 0){

                    result[index++] = new int[]{r0 - j,c0 - i};
                    if (index >= result.length){
                        return result;
                    }
                }
                if (j > 0 && r0 + j < R-1 && c0 - i >= 0){
                    result[index++] = new int[]{r0 + j,c0 - i};
                    if (index >= result.length){
                        return result;
                    }
                }



            }
        }
        return result;
    }

}
