package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00089GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        if (n == 1) return result;

        for (int i = 2; i <= n; i++) {
            int num = (int) Math.pow(2, i - 1);
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + num);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Integer.toBinaryString(result.get(i)));
        }
        return result;
    }
}