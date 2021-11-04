package com.mydd.algorithm.code.leetcode;

public class LC00005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        char[] sChar = s.toCharArray();
        int sLen = s.length();
        int checkNums = 2 * sLen - 1;
        int pos = sLen - 1;
        int maxLen = 0;
        int tempLen = 0;
        boolean flag = true;
        int bound;
        int indexR = 1, indexL = 0;
        String tempStr = "";
        while(pos < checkNums || pos > -1) {
            if(pos % 2 == 0) {
                bound = flag ? checkNums - pos + 1 : pos + 1;
                if (bound < maxLen) {
                    break;
                }
                indexR = pos / 2;
                indexL = indexR - 1;
                tempLen = 0;
                pos = flag ? pos + 1 : pos - 1;
            } else {
                bound = flag ? checkNums - pos + 1 : pos + 1;
                if (bound < maxLen) {
                    break;
                }
                indexL = pos / 2 - 1;
                indexR = indexL + 2;
                tempLen = 1;
                flag = !flag;
                pos = checkNums - pos;
            }
            while (indexL > -1 && indexR < sLen && sChar[indexL] == sChar[indexR]) {
                tempLen += 2;
                indexL -= 1;
                indexR += 1;
            }
            if (maxLen < tempLen) {
                maxLen = tempLen;
                tempStr = s.substring(indexL + 1, indexR);
            }
        }
        return tempStr;
    }
}
