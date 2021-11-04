package com.mydd.algorithm.code.leetcode;

public class LC00053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = nums[0], i = 0;
        while (max <= 0 && i < len) {
            max = nums[i] > max ? nums[i] : max;
            i++;
        }
        int tmpSum = max;
        while (i < len) {
            while (i < len && tmpSum + nums[i] > 0) {
                tmpSum += nums[i++];
                max = tmpSum > max ? tmpSum : max;
            }
            while (i < len && nums[i] <= 0) i++;
            tmpSum = 0;
        }
        return max;
    }
}
