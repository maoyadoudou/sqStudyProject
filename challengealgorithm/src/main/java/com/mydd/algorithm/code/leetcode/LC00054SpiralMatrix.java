package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length - 1, col = matrix[0].length - 1, startI = 0, startJ = 0, total = matrix.length * (col + 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; result.size() == total;) {
            while (j <= col) {
                result.add(matrix[i][j++]);
            }
            j--;
            i = ++startI;
            while (i <= row) {
                result.add(matrix[i++][j]);
            }
            i--;
            j = --col;
            while (j >= startJ) {
                result.add(matrix[i][j--]);
            }
            j++;
            i = --row;
            while (i >= startI) {
                result.add(matrix[i--][j]);
            }
            i++;
            j = ++startJ;
        }
        return result;
    }
}
