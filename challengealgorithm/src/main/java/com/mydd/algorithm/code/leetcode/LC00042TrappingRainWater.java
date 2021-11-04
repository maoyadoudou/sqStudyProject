package com.mydd.algorithm.code.leetcode;

public class LC00042TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lh = height[l], rh = height[r], vol = (r - l + 1) * Math.min(lh, rh), sum = 0;
        for(int item : height){
            sum += item;
        }
        while(l < r) {
            if (lh < rh) {
                if (height[++l] > lh) {
                    vol += (r - l + 1) * (Math.min(height[l], rh) - lh);
                    lh = height[l];
                }
            } else if (lh > rh) {
                if (height[--r] > rh) {
                    vol += (r - l + 1) * (Math.min(height[r], lh) - rh);
                    rh = height[r];
                }
            } else {
                if (height[++l] > lh) {
                    lh = height[l];
                }
            }
        }
        return vol - sum;
    }
}
