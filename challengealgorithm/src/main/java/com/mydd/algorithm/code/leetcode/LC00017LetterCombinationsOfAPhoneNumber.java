package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00017LetterCombinationsOfAPhoneNumber {
    private final static char[] TWO   = new char[]{'a', 'b', 'c'};
    private final static char[] THREE = new char[]{'d', 'e', 'f'};
    private final static char[] FOUR  = new char[]{'g', 'h', 'i'};
    private final static char[] FIVE  = new char[]{'j', 'k', 'l'};
    private final static char[] SIX   = new char[]{'m', 'n', 'o'};
    private final static char[] SEVEN = new char[]{'p', 'q', 'r', 's'};
    private final static char[] EIGHT = new char[]{'t', 'u', 'v'};
    private final static char[] NINE  = new char[]{'w', 'x', 'y', 'z'};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new ArrayList<>();
        if(len == 0) return res;
        List<StringBuilder> resB = new ArrayList();
        if(len == 1) {
            int lenO = numLen(digits.charAt(0));
            char n[] = numArray(digits.charAt(0));
            for (int i = 0; i < lenO; i++) {
                res.add(String.valueOf(n[i]));
            }
            return res;
        }
        StringBuilder[] sb = getCombination(len, digits);
        sb[0].append(digits.charAt(0));
        for(StringBuilder item : sb) {
            res.add(item.toString());
        }
        return res;
    }

    private StringBuilder[] getCombination(int len, String digits) {
        int total = 1, i = 0;
        while(i < len) {
            total *= numLen(digits.charAt(i++));
        }
        StringBuilder[] sb = new StringBuilder[total];
        len = numLen(digits.charAt(0));
        int j, offset, subLen = total / len;
        char[] ch = numArray(digits.charAt(0));
        for(i = 0; i < len; i++){
            j = 0;
            offset = i * subLen;
            while(j < subLen) {
                sb[j + offset] = new StringBuilder().append(ch[i]);
                j++;
            }
        }
        return assemble(sb, 1, digits, subLen / numLen(digits.charAt(1)));
    }

    private StringBuilder[] assemble(StringBuilder[] sb, int index, String digits, int subLen) {
        int len = sb.length, l = 0, j, offset, stage;
        char c = digits.charAt(index);
        char[] ch = numArray(c);
        while(l < len) {
            stage = l;
            for(int i = 0; i < numLen(c); i++) {
                j = 0;
                offset = i * subLen + stage;
                while(j < subLen) {
                    sb[j + offset].append(ch[i]);
                    j++;
                    l++;
                }
            }
        }

        index++;
        if(index == digits.length()) return sb;
        subLen /= numLen(digits.charAt(index));
        return assemble(sb, index, digits, subLen);
    }


    private char[] numArray(char n) {
        switch(n) {
            case '2': return TWO;
            case '3': return THREE;
            case '4': return FOUR;
            case '5': return FIVE;
            case '6': return SIX;
            case '7': return SEVEN;
            case '8': return EIGHT;
            case '9': return NINE;
        }
        return new char[0];
    }

    private int numLen(char n) {
        switch(n) {
            case '7':
            case '9':
                return 4;
        }
        return 3;
    }
}
