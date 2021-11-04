package com.mydd.algorithm.code.leetcode;

public class LC00045JumpGameII {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (len - 1 <= nums[0]) return 1;
        int i = 0, j, max, next, step = 0;
        while (i < len - 1) {
            j = i + 1;
            max = 0;
            next = 0;
            // find best next point
            while (j <= nums[i] + i && j < len) {
                if (max < nums[j]) {
                    max = nums[j];
                    next = j;
                }
                if (max > 0) max--;
                j++;
            }
            // no best next point, reset step to 0
            if (next == 0 || nums[next] == 0) {
                step = 0;
                break;
            }
            //
            step++;
            if (nums[next] + next >= len - 1) {
                step++;
                break;
            }
            i = next;
        }
        return step;
    }
}
