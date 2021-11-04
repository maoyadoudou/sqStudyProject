package com.mydd.algorithm.code.leetcode;

/*
   243 = 3 ** 5
   9 * 9 * 3
   5 = 101
   5 - 1 = 4      list.add(3)
   4 >> 1 = 2    3 * 3 = 9
   2 >> 1 = 1    9 * 9 = 81
   1 % 2 = 1     list.add(81)
 */

public class LC00050Powxn {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1D) return 1;
        if (n > 0) {
            return getPowerValue(x, n);
        } else {
            n += 1;
            return 1.0D / (x * getPowerValue(x, -n));
        }
    }

    private double getPowerValue(double x, int n) {
        double res = 1D;
        while (n != 0) {
            if (n % 2 == 1) {
                res *= x;
                n -= 1;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
