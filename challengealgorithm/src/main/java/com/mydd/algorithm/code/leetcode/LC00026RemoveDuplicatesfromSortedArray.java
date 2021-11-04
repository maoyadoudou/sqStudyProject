package com.mydd.algorithm.code.leetcode;

public class LC00026RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for (int num : nums) {
            if(num != nums[i]) {
                nums[++i] = num;
            }
        }
        return ++i;
    }
}
