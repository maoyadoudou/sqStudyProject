package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00007ReverseInteger {

    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (x == max || x == min) {
            return 0;
        }
        boolean isPositive = x >= 0;
        int numb = isPositive ? x : -x;
        int signed = isPositive ? 1 : -1;
        int rest;
        List<Integer> list = new ArrayList();
        int digit = 0;
        while(numb != 0) {
            digit++;
            rest = numb / 10;
            list.add(numb - rest * 10);
            numb = rest;
        }
        int result = 0;
        if (digit < 10) {
            for(int i = 0; i < digit; i++) {
                result = list.get(i) + 10 * result;
            }
            return signed * result;
        } else {
            if (list.get(0) > 2) {
                return 0;
            }
            for(int i = 0; i < 9; i++) {
                result = list.get(i) + 10 * result;
            }
            int times = 0;
            rest = max - list.get(9);
            while(rest > 0) {
                rest = rest - result;
                times++;
            }
            if (times <= 10) {
                return 0;
            } else {
                return signed * (result * 10 + list.get(9));
            }
        }

    }
}
