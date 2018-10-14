package com.vitoz.campus.huawei;

import java.util.Scanner;

/**
 * @Author: vitoz
 * @Date: 2018/10/13 19:47
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[][] grid = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxAreaOfIsland(grid, visited));
    }
    public static int getMaxAreaOfIsland(int[][] grid, boolean[][] visited) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    result = Math.max(result, getAreaOfIsland(grid, i, j, visited));
                }
            }
        }

        return result;
    }

    public static int getAreaOfIsland(int[][] grid, int i, int j, boolean[][] visited){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]){
//            grid[i][j] = 0;
            visited[i][j] = true;
            return 1 + getAreaOfIsland(grid,i+1,j, visited) + getAreaOfIsland(grid,i-1,j, visited) + getAreaOfIsland(grid,i,j+1, visited) + getAreaOfIsland(grid,i,j-1, visited);
        }
        return 0;
    }
}