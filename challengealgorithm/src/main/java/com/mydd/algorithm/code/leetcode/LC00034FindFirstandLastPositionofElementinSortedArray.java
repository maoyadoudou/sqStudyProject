package com.mydd.algorithm.code.leetcode;

public class LC00034FindFirstandLastPositionofElementinSortedArray {
    int num, left, right;
    public int[] searchRange(int[] nums, int target) {
        num = target;
        binarySearch(nums, 0, nums.length - 1);
        return new int[]{left, right};
    }

    private void binarySearch(int[] nums, int lo, int hi) {
        if(lo > hi) {
            left = -1;
            right = -1;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(num > nums[mid]) binarySearch(nums, mid + 1, hi);
        else if (num < nums[mid]) binarySearch(nums, lo, mid - 1);
        else {
            binarySearchEndLeft(nums, lo, mid - 1);
            binarySearchEndRight(nums, mid + 1, hi);
        }
    }

    private void binarySearchEndLeft(int[] nums, int lo, int hi) {
        if(lo > hi) {
            left = hi + 1;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(num > nums[mid]) binarySearchEndLeft(nums, mid + 1, hi);
        else binarySearchEndLeft(nums, lo, mid - 1);
    }

    private void binarySearchEndRight(int[] nums, int lo, int hi) {
        if(lo > hi) {
            right = lo - 1;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(num >= nums[mid]) binarySearchEndRight(nums, mid + 1, hi);
        else binarySearchEndRight(nums, lo, mid - 1);
    }
}
