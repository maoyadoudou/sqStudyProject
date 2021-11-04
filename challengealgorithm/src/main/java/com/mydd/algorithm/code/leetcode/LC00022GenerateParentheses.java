package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00022GenerateParentheses {
    List<String> res;
    int left, right;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        left = 1;
        right = 0;
        combinationIter(new StringBuilder(), n, '(');
        return res;
    }

    private void combinationIter(StringBuilder sb, int num, char c) {
        if (right > left || right > num || left > num) return;
        sb.append(c);
        if (right == num) {
            res.add(sb.toString());
            return;
        }

        left++;
        combinationIter(sb, num, '(');
        left--;
        sb.setLength(left + right);

        right++;
        combinationIter(sb, num, ')');
        right--;
        sb.setLength(left + right);
    }
}
