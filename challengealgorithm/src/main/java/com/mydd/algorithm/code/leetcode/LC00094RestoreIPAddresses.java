package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

//"101023"
//        Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//101023
//101
// 010
//  102
//    23
public class LC00094RestoreIPAddresses {
    List<String> result;
    int len;
    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        if (len < 4 || len > 12) return new ArrayList<>();
        char[] chars = s.toCharArray();
        int[][] numArray = new int[4][len];
        for (int i = 0; i < len; i++) {
            if (i < 3 && len - i - 1 >= 3) numArray[0][i] = chars[i] - '0';
            else numArray[0][i] = -1;
            if (i > 0 && len - i - 1 >= 2 && i < 6) numArray[1][i] = chars[i] - '0';
            else numArray[1][i] = -1;
            if (i > 1 && len - i - 1 >= 1 && i < 9) numArray[2][i] = chars[i] - '0';
            else numArray[2][i] = -1;
            if (i > 2 && len - i <= 3) numArray[3][i] = chars[i] - '0';
            else numArray[3][i] = -1;
        }
        StringBuilder sb = new StringBuilder();
        result = new ArrayList<>();
        findPath(numArray, 0, 1, 0, sb);
        findPath(numArray, 0, 2, 0, sb);
        findPath(numArray, 0, 3, 0, sb);
        return result;
    }

    private void findPath(int[][] numArray, int start, int numLen, int count, StringBuilder sb) {
        int sbLen = sb.length();
        if (count == 4) {
            if (start < len) return;
            sb.setLength(sbLen - 1);
            result.add(sb.toString());
            return;
        }
        int end = start + numLen - 1;
        if (end >= len || numArray[count][start] == -1 || (numArray[count][start] == 0 && numLen > 1)) return;
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + numArray[count][i];
        }
        if (num > 255) return;
        sb.append(num).append('.');
        if (count == 3) {
            findPath(numArray, end + 1, numLen, count + 1, sb);
        } else {
            for (numLen = 1; numLen < 4; numLen++) {
                findPath(numArray, end + 1, numLen, count + 1, sb);
            }
        }
        sb.setLength(sbLen);
    }
}
