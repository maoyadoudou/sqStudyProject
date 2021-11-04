package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00049GroupAnagrams {
    String[] aux;
    int[] count;
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> res = new ArrayList<>();
        if (len == 1) {
            res.add(new ArrayList<String>(Arrays.asList(strs)));
            return res;
        }
        count = new int[102];
        for(int i = 0; i < len; i++) {
            count[strs[i].length() + 1]++;
        }
        for(int i = 1; i < 102; i++) {
            count[i] += count[i - 1];
        }
        aux = new String[len];
        for(int i = 0; i < len; i++) {
            aux[count[strs[i].length()]++] = strs[i];
        }
        int lo = 0;
        if (aux[lo].length() == 0) {
            res.add(new ArrayList<String>(Arrays.asList("")));
            while(++lo < len && aux[lo].length() == 0) res.get(0).add("");
        }
        if (lo == len) return res;

        pickStrings(lo, res);
        System.gc();
        return res;
    }

    private void pickStrings(int lo, List<List<String>> res) {
        while (lo < aux.length) {
            int hi = count[aux[lo].length()], validNum = 0, base = res.size();
            int[][] validMark = new int[hi - lo][26];
            for (; lo < hi; lo++) {
                int[] aValidMark = getCount(aux[lo]);
                int j = 0;
                while (j < validNum && !arrayCompare(aValidMark, validMark[j])) j++;
                if (j < validNum) {
                    res.get(base + j).add(aux[lo]);
                } else  {
                    validMark[validNum++] = aValidMark;
                    res.add(new ArrayList(Arrays.asList(aux[lo])));
                }
            }
        }
    }

    private int[] getCount(String str) {
        int[] count = new int[26];
        for(char ch : str.toCharArray()) count[ch - 'a']++;
        return count;
    }

    private boolean arrayCompare(int[] count1, int[] count2) {
        int i = 0;
        while (i < count1.length && count1[i] == count2[i]) i++;
        return i == count1.length;
    }
}
