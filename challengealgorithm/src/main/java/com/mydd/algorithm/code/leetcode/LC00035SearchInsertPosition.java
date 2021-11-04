package com.mydd.algorithm.code.leetcode;

public class LC00035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) return nums[0] < target ? 1 : 0 ;
        return binarySearch(nums, 0, len - 1, target);
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > target) return binarySearchLeft(nums, lo, mid - 1, target);
        else if (nums[mid] < target) return binarySearchRight(nums, mid + 1, hi, target);
        else return mid;
    }

    private int binarySearchLeft(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return hi + 1;
        return binarySearch(nums, lo, hi, target);
    }

    private int binarySearchRight(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return lo;
        return binarySearch(nums, lo, hi, target);
    }
}
