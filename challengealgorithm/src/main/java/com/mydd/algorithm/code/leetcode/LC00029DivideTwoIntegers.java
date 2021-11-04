package com.mydd.algorithm.code.leetcode;

public class LC00029DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int a = Integer.MAX_VALUE  - 1;
        a <<= 1;
        if(dividend == 0) return 0;
        if(dividend == divisor) return 1;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        boolean isPositive = divisor > 0;
        if(divisor > dividend) {
            divisor = isPositive ? divisor : -divisor;
            if(dividend > 0 || divisor + dividend > 0) return 0;
            else {
                int i = 0;
                while((dividend += divisor) <= 0) i++;
                return isPositive ? -i : i;
            }
        } else {
            divisor = isPositive ? -divisor : divisor;
            if(dividend < 0 || divisor + dividend < 0) return 0;
            else {
                int i = 0;
                while((dividend += divisor) >= 0) i++;
                return isPositive ? i : -i;
            }
        }
    }

    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sameSign = (dividend ^ divisor) >= 0;
        int d1 = Math.abs(dividend);
        int d2 = Math.abs(divisor);
        int result = 0;
        while (d1 - d2 >= 0) {
            int tmp = d2;
            int count = 1;
            while (d1 - (tmp << 1) >= 0) {
                tmp <<= 1;
                count <<= 1;
            }
            d1 -= tmp;
            result += count;
        }

        return sameSign ? result : -result;
    }
}
