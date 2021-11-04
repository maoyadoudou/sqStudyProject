package com.mydd.algorithm.code.leetcode;

public class LC00027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0) return 0;
        for(int i = 0; i < len; i++) {
            if(val != nums[i]) continue;
            while(len > 0 && nums[len - 1] == val) len--;
            if(len <= i) break;
            nums[i] = nums[len - 1] + 0 * (nums[len - 1] = nums[i]);
            len--;
        }
        return len;
    }
}
