package com.mydd.algorithm.code.leetcode;

public class LC00012IntegertoRoman {
    public String intToRoman(int num) {
        int[] number = new int[]{1,5,10,50,100,500,1000};
        char[] roman = new char[]{'I','V','X','L','C','D','M'};
        StringBuilder result = new StringBuilder();
        int i = 6, j = 4;
        while(num > 0) {
            if (num >= number[i]) {
                num -= number[i];
                result.append(roman[i]);
                continue;
            }
            if (num + number[j] >= number[i]) {
                num -= number[i];
                num += number[j];
                result.append(roman[j]).append(roman[i]);
            }
            i--;
            j = j == i && j > 0 ? j - 2 : j;
        }
        return result.toString();
    }
}
