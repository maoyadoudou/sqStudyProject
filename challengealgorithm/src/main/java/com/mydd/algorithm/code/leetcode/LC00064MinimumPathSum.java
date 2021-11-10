package com.mydd.algorithm.code.leetcode;

public class LC00064MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int[][] path = new int[rowSize][colSize];
        path[0][0] = grid[0][0];
        for (int i = 1; i < rowSize; i++) path[i][0] = grid[i][0] + path[i - 1][0];
        for (int j = 1; j < colSize; j++) path[0][j] = grid[0][j] + path[0][j - 1];
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                path[i][j] = grid[i][j] + Math.min(path[i - 1][j], path[i][j - 1]);
            }
        }
        return path[rowSize - 1][colSize - 1];
    }
}
