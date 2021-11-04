package com.mydd.algorithm.code.leetcode;

public class LC00115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int lenS = s.length(), lenT = t.length(), count = 0, i, j, delta = lenS - lenT + 1;
        int[] idxT = new int[lenT];
        for(i = 0, j = 0; j < lenT && i < delta + j; i++) {
            if(s.charAt(i) == t.charAt(j)) {
                idxT[j++] = i;
            }
        }
        if(j < lenT) return 0;
        count++;
        int localMax;
        int[] sts = new int[lenS];
        for(i = lenS - 1; i > idxT[lenT - 1]; i--) {
            if(s.charAt(i) == t.charAt(lenT - 1)) {
                sts[i] = 1;
                count++;
            }
        }
        sts[idxT[lenT - 1]] = 1;
        for(j = lenT - 2; j > -1; j--) {
            localMax = 0;
            for(i = lenS - 1; i > idxT[j]; i--) {
                if(i <= lenS - (lenT - j) && s.charAt(i) == t.charAt(j)) {
                    count += localMax;
                    sts[i] = localMax + 0 * (localMax += sts[i]);
                    if (i == idxT[j] + 1) break;
                    continue;
                }
                localMax += sts[i];
                sts[i] = 0;
            }
            sts[idxT[j]] = localMax;
        }
        return count;
    }
}
