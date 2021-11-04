package com.mydd.algorithm.code.leetcode;

import java.util.Stack;

public class LC00032LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> a = new Stack<>();
        int length = 0;
        a.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                a.push(i);
            } else {
                a.pop();
                if(a.empty()) {
                    a.push(i);
                } else {
                    length = Math.max(length, i - a.peek());
                }
            }
        }
        return length;
    }

    public int longestValidParentheses1(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = i < 2 ? 2 : 2 + dp[i - 2];
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
