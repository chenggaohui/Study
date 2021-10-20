package com.hhh.study.面试算法;

public class 岛屿面积 {

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','1','1','1','0'},
                                    {'1','1','0','1','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','0','0','0'},
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        System.out.println(sumIslands(arr,9));
    }


    public static int sumIslands(char[][] grid, int S){

        if (grid == null || grid.length == 0){
            return 0;
        }
        char nextIndex = '2';

        for (int i = 0; i < grid.length - 1; i++){
            for (int j = 0; j < grid[i].length - 1; j++){
                if (grid[i][j] == '0'){
                    continue;
                }
                if (grid[i][j] == '1'){
                    grid[i][j] = nextIndex;
                    nextIndex = (char)(nextIndex + 1);
                }
                if (grid[i + 1][j] == '1'){
                    grid[i + 1][j] = grid[i][j];
                }
                if (grid[i][j + 1] == '1'){
                    grid[i][j + 1] = grid[i][j];
                }


            }
        }

        int[] arr = new int[nextIndex - '1' + 1];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '0') continue;
                arr[grid[i][j] - '1']++;
            }
        }

        int result = 0;
        for (int i : arr){
            if (i == S) result++;
        }
        return result;
    }

}



