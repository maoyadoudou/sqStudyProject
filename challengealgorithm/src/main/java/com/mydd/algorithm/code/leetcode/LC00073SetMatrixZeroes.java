package com.mydd.algorithm.code.leetcode;

public class LC00073SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] dp = new boolean[n];
        boolean rowClear = false;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == 0 ? true : dp[j];
                if (!rowClear && dp[j]) {
                    rowClear = true;
                    int k = j - 1;
                    while (k >=0) matrix[i][k--] = 0;
                }
                if (rowClear) matrix[i][j] = 0;
            }
            rowClear = false;
        }
        for (int j = 0; j < n; j++) {
            if (dp[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
}
