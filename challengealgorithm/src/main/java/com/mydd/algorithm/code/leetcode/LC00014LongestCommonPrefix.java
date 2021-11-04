package com.mydd.algorithm.code.leetcode;

public class LC00014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        char[] commonPrefix = strs[0].toCharArray();
        int lenPrefix = strs[0].length(), i = 1, j = 0, len = strs.length, tmpLen;
        while(i < len && lenPrefix > 0) {
            tmpLen = strs[i].length();
            while(j < lenPrefix && j < tmpLen) {
                if(commonPrefix[j] != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            lenPrefix = j;
            j = 0;
            i++;
        }
        return lenPrefix == 0 ? "" : strs[0].substring(0, lenPrefix);
    }
}
