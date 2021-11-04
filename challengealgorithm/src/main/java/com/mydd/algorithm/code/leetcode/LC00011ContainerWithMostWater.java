package com.mydd.algorithm.code.leetcode;

public class LC00011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length - 1;
        int lh = height[0], rh = height[len];
        boolean maxRight = rh > lh;
        if (len == 1) {
            return maxRight ? lh : rh;
        }
        return maxRight ? moveLeftWall(height, 0, len, lh * len) : moveRightWall(height, 0, len, rh * len);
    }

    public int moveLeftWall(int[] height, int l, int r, int sMax) {
        int min = height[l];
        int max = height[r];
        int i = l;
        int newH = height[i];
        int newArea;
        while(newH <= max && i < r) {
            if(newH >= min) {
                newArea = (r - i) * newH;
                if (newArea > sMax) {
                    sMax = newArea;
                }
            }
            newH = height[++i];
        }
        return i == r ? sMax : moveRightWall(height, i, r, sMax);
    }

    public int moveRightWall(int[] height, int l, int r, int sMax) {
        int max = height[l];
        int min = height[r];
        int i = r;
        int newH = height[i];
        int newArea;
        while(newH <= max && i > l) {
            if(newH >= min) {
                newArea = (i - l) * newH;
                if (newArea > sMax) {
                    sMax = newArea;
                }
            }
            newH = height[--i];
        }
        return i == l ? sMax : moveLeftWall(height, l, i, sMax);
    }

}
