package com.mydd.algorithm.code.leetcode;

public class LC00048RotateImage {
    public void rotate(int[][] matrix) {
        int height = matrix.length;
        if (height == 1) return;
        int width = matrix[0].length;
        // vertical reverse
        for (int up = 0, down = height - 1; up < down; up++, down--) {
            for (int i = 0; i < width; i++) {
                matrix[up][i] = matrix[down][i] + 0 * (matrix[down][i] = matrix[up][i]);
            }
        }

        for (int i = 0; i < height - 1; i++) {
            for (int j = i + 1; j < width; j++) {
                matrix[i][j] = matrix[j][i] + 0 * (matrix[j][i] = matrix[i][j]);
            }
        }
    }
}
