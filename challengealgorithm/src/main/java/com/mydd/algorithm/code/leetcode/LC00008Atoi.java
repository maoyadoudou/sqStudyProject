package com.mydd.algorithm.code.leetcode;

public class LC00008Atoi {
    public int atoi(String s) {
        boolean isPositive = true;
        int len = s.length(), signal = 0;
        int i = 0;
        for (; i < len; i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                if(signal == 0  && s.charAt(i) == ' ') {
                    continue;
                }
                if(s.charAt(i) != '-' && s.charAt(i) != '+') {
                    return 0;
                }
                signal++;
                if (signal > 1) {
                    return 0;
                }
                continue;
            } else {
                isPositive = !(signal == 1 && s.charAt(i - 1) == '-');
                break;
            }
        }
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        int value = 0;
        int appendNum;
        if (isPositive) {
            for (; i < len && Character.isDigit(s.charAt(i)); i++) {
                appendNum = s.charAt(i) - '0';
//                if (appendNum > 9 || appendNum < 0) return value;
                if (value > max || (value == max && appendNum > 7)) return Integer.MAX_VALUE;
                value = value * 10 + appendNum;
            }
        } else {
            for (; i < len && Character.isDigit(s.charAt(i)); i++) {
                appendNum = s.charAt(i) - '0';
//                if (appendNum > 9 || appendNum < 0) return value;
                if (value < min || (value == min && appendNum > 8)) return Integer.MIN_VALUE;
                value = value * 10 - appendNum;
            }
        }
        return value;
    }
}
