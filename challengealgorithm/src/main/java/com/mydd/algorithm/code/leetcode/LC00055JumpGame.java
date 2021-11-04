package com.mydd.algorithm.code.leetcode;

public class LC00055JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int len = nums.length, last = len - 1, i;
        if (nums[last] == 0) {
            i = last - 1;
            while (i > -1 && nums[i] < last - i) i--;
            if (i < 0) return false;
            last = i;
        }
        while(true) {
            while(last >= 0 && nums[last] != 0) last--;
            if (last <= 0) return true;

            i = last - 1;
            while (i > -1 && nums[i] <= last - i) i--;
            if (i < 0) return false;

            last = i;
        }
    }
}
