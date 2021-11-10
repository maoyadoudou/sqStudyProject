package com.mydd.algorithm.code.leetcode;

public class LC00063UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        else obstacleGrid[0][0] = 1;
        int rowSize = obstacleGrid.length, colSize = obstacleGrid[0].length;
        for (int i = 1; i < rowSize; i++) {
            if (obstacleGrid[i][0] == 0) obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            else obstacleGrid[i][0] = 0;
        }
        for (int j = 1; j < colSize; j++) {
            if (obstacleGrid[0][j] == 0) obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            else obstacleGrid[0][j] = 0;
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (obstacleGrid[i][j] == 0) obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                else obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[rowSize - 1][colSize - 1];
    }
}
