package com.mydd.algorithm.code.leetcode;

public class LC00013RomantoInteger {
//    public final static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public final static char[] romanCh = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    public final static int[] numb = new int[]{1000, 500, 100, 50, 10, 5, 1};
    public int romanToInt(String s) {
        char[] sChar = s.toCharArray();
        int i = 0, j = 2, index = 0, len = s.length();
        int result = 0;
        while(index < len) {
            if(sChar[index] == romanCh[i]) {
                result += numb[i];
                index++;
                continue;
            } else if (index + 1 < len && sChar[index + 1] == romanCh[i]) {
                result += numb[i];
                result -= numb[j];
                index += 2;
            }
            i++;
            j = j == i && j < 6 ? j + 2 : j;
        }
        return result;
    }
}
