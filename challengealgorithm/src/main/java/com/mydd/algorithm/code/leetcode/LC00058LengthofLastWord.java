package com.mydd.algorithm.code.leetcode;

public class LC00058LengthofLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int lastLen = 0, i = s.length() - 1;
        while (i >= 0 && chars[i] == ' ') i--;
        while (i >= 0 && chars[i--] != ' ') lastLen++;
        return lastLen;
    }
}
