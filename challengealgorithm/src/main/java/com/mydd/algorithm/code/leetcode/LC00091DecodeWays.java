package com.mydd.algorithm.code.leetcode;

public class LC00091DecodeWays {
    public int numDecodings(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len == 1) return "0".equals(s) ? 0 : 1;
        char[] chars = s.toCharArray();
        int dp1 = 0, dp2 = 0, dp = 0;
        if (chars[0] != '0') {
            dp1 = 1;
            dp2 = 1;
        }
        else return 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') dp = 0;
            else dp = dp1;
            int tmp = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (tmp > 9 && tmp < 27) dp += dp2;
            else if (chars[i] == '0') return 0;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }


    public int numDecodings1(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len == 1) return "0".equals(s) ? 0 : 1;
        char[] chars = s.toCharArray();
        int[] decodingNum = new int[len + 1];
        if (chars[0] != '0') decodingNum[1] = 1;
        else return 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') decodingNum[i + 1] = 0;
            else decodingNum[i + 1] = decodingNum[i];
            int tmp = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (tmp > 9 && tmp < 27) decodingNum[i + 1] += decodingNum[i - 1] == 0 ? 1 : decodingNum[i - 1];
            else if (chars[i] == '0') return 0;
        }
        return decodingNum[len];
    }
}
