package com.mydd.algorithm.code.leetcode;

public class LC00074Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearchRow(matrix, 0, matrix.length - 1, target);
    }

    private boolean binarySearchRow(int[][] matrix, int lo, int hi, int target) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (target > matrix[mid][matrix[0].length - 1]) return binarySearchRow(matrix, mid + 1, hi, target);
        else if (target < matrix[mid][0]) return binarySearchRow(matrix, lo, mid - 1, target);
        else return binarySearch(matrix[mid], 0, matrix[0].length - 1, target);
    }

    private boolean binarySearch(int[] array, int lo, int hi, int target) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (target > array[mid]) return binarySearch(array, mid + 1, hi, target);
        else if (target < array[mid]) return binarySearch(array, lo, mid - 1, target);
        else return true;
    }
}
