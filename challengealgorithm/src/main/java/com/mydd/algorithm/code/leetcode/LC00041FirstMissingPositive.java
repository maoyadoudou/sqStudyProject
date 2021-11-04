package com.mydd.algorithm.code.leetcode;

public class LC00041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i, end = nums.length, tmp, index;
        for(i = 0; i < end;) {
            while (nums[i] != i + 1 && i < end) {
                tmp = nums[i];
                if (nums[i] <= i || nums[i] > end || nums[tmp - 1] == nums[i]) {
                    index = --end;
                } else {
                    index = tmp - 1;
                }
                nums[i] = nums[index];
                nums[index] = tmp;
            }
            if (nums[i] == i + 1) i++;
        }
        return i + 1;
    }
}
