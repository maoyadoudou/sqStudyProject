package com.mydd.algorithm.code.leetcode;

public class LC00028ImplementstrStr {
    int[][] dfa;
    int lenH, lenN;
    public int strStr(String haystack, String needle) {
        lenH = haystack.length();
        lenN = needle.length();
        if(lenN > lenH) return -1;
        if(lenN == 0) return 0;
        KMP(needle.toCharArray());
        return searchIn(haystack.toCharArray());
    }

    private void KMP(char[] patten) {
        dfa = new int[26][lenN];
        dfa[patten[0] - 'a'][0] = 1;
        for(int X = 0, j = 1; j < lenN; j++) {
            for(int i = 0; i < 26; i++) {
                dfa[i][j] = dfa[i][X];
            }
            dfa[patten[j] - 'a'][j] = j + 1;
            X = dfa[patten[j] - 'a'][X];
        }
    }

    private int searchIn(char[] chars) {
        int i, j;
        for(i = 0, j = 0; i < lenH && j < lenN; i++) {
            j = dfa[chars[i] - 'a'][j];
        }
        if (j == lenN) return i - lenN;
        else return -1;
    }
}
