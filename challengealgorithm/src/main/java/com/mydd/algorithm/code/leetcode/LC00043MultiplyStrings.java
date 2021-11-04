package com.mydd.algorithm.code.leetcode;

public class LC00043MultiplyStrings {
    public String multiply(String num1, String num2) {
        return num1.length() > num2.length() ? multiplyString(num1, num2) : multiplyString(num2, num1);
    }

    private String multiplyString(String longerStr, String shorterStr) {
        char[] shortArray = shorterStr.toCharArray();
        char[] longArray = longerStr.toCharArray();
        int lineUp, lineNum, resUp, resNum, i, j, index;

        int[] reverseRes = new int[shortArray.length + longArray.length];
        for (i = shortArray.length - 1; i >= 0; i--) {
            index = shortArray.length - i - 1;
            resUp = 0;
            lineUp = 0;
            for (j = longArray.length - 1; j >= 0; j--) {
                lineNum = (shortArray[i] - '0') * (longArray[j] - '0') + lineUp;
                lineUp = lineNum / 10;
                lineNum %= 10;

                resNum = reverseRes[index] + lineNum + resUp;
                resUp = resNum / 10;
                reverseRes[index] = resNum % 10;
                index++;
            }
            while (resUp > 0 || lineUp > 0) {
                resNum = reverseRes[index] + lineUp + resUp;
                resUp = resNum / 10;
                reverseRes[index] = resNum % 10;
                index++;
                lineUp = 0;
            }
        }
        i = reverseRes.length - 1;
        while (i > 0 && reverseRes[i] == 0) {
            i--;
        }
        StringBuilder sb = new StringBuilder();
        while (i >= 0) sb.append(reverseRes[i--]);
        return sb.reverse().toString();
    }
}
