package com.mydd.algorithm.code.leetcode;

public class LC00059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, down = n - 1, left = 0, right = n - 1;
        for (int i = 0, j = 0, count = 0; top <= down && left <= right; ) {
            while (j <= right) result[i][j++] = ++count;
            j--;
            i++;
            top++;
            while (i <= down) result[i++][j] = ++count;
            i--;
            j--;
            right--;
            while (j >= left) result[i][j--] = ++count;
            j++;
            i--;
            down--;
            while (i >= top) result[i--][j] = ++count;
            i++;
            j++;
            left++;
        }
        System.gc();
        return result;
    }
}
