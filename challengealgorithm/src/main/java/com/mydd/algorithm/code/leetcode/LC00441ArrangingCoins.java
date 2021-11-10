package com.mydd.algorithm.code.leetcode;

public class LC00441ArrangingCoins {
    public int arrangeCoins(int n) {
        long res = 0, left = 0, right = n;
        long mid, total;
        while (left <= right) {
            mid = left + (right - left) / 2;
            total = mid * (mid + 1) / 2;
            if (n > total) {
                left = mid + 1;
                res = mid;
            }
            else if (n < total) right = mid - 1;
            else {
                res = mid;
                break;
            }
        }
        return (int) res;
    }

    public int arrangeCoins1(int n) {
        int total = 0, m = 0;
        while (n - total > m) {
            m++;
            total += m;
        }
        return m;
    }
}
