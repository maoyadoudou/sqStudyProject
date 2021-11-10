package com.mydd.algorithm.code.leetcode;

public class LC00062UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] pathMatrix = new int[m][n];
        for (int i = 0; i < m; i++) pathMatrix[i][0] = 1;
        for (int j = 0; j < n; j++) pathMatrix[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathMatrix[i][j] = pathMatrix[i - 1][j] + pathMatrix[i][j - 1];
            }
        }
        return pathMatrix[m - 1][n - 1];
    }
}
