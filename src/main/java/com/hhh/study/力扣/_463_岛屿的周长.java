package com.hhh.study.力扣;

public class _463_岛屿的周长 {

    public static void main(String[] args) {
        int[][] arr = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        System.out.println(islandPerimeter(arr));

    }


    public static int islandPerimeter(int[][] grid) {

        int result = 0;

        for (int i = 0; i <grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    result += 4;
                    if (j>=1 && grid[i][j-1] == 1){
                        result -=2;
                    }

                    if (i>=1 && grid[i-1][j] ==1){
                        result -= 2;
                    }

                }
            }
        }

        return result;
    }
}
