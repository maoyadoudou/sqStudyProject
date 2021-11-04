package com.mydd.algorithm.code.leetcode;

public class LC00031NextPermutation {
    int target, index;
    public void nextPermutation(int[] nums) {
        int len = nums.length, i = len - 1;
        while(i > 0 && nums[i - 1] >= nums[i]) i--;
        if(i > 0) {
            target = nums[i - 1];
            binarySearch(nums, i, len - 1);
            nums[i - 1] = nums[index] + 0 * (nums[index] = nums[i - 1]);
        }
        for(int j = len - 1; i < j && nums[i] > nums[j]; j--, i++) {
            nums[j] = nums[i] + 0 * (nums[i] = nums[j]);
        }
    }

    private void binarySearch(int[] nums, int lo, int hi) {
        if (lo > hi) return;
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] > target) {
            index = mid;
            binarySearch(nums, mid + 1, hi);
        } else {
            if(target < nums[lo]) index = lo;
            binarySearch(nums, lo, mid - 1);
        }
    }
}
