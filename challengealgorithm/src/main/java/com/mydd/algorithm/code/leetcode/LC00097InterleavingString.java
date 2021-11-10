package com.mydd.algorithm.code.leetcode;

public class LC00097InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[] dp = new boolean[len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) dp[j] = true;
                else if (i == 0) dp[j] = s3.charAt(j - 1) == s2.charAt(j - 1) && dp[j - 1];
                else if (j == 0) dp[j] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[j];
                else dp[j] = s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[j - 1] || (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[j]);
            }
        }
        return dp[len2];
    }

    // 2-D DP , after see the solution
    public boolean isInterleave3(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s3.charAt(j - 1) == s2.charAt(j - 1) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][j];
                } else {
                    dp[i][j] = (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) || (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    // Both two method (isInterleave 1,2) I didn't notice the repeat compare condition,
    // if s1 has compared is, s2 has compared js, when compare (i + j + 1)s,
    // it may have been compared at least once. That's the reason my method exceed the time.
    // My fault :(
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len3 == 0) return true;
        if (len2 == 0) {
            while(len2 < len1 && s1.charAt(len2) == s3.charAt(len2)) len2++;
            return len2 == len1;
        }
        if (len1 == 0) {
            while(len1 < len2 && s2.charAt(len1) == s3.charAt(len1)) len1++;
            return len1 == len2;
        }

        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0)
                || dfs(s2.toCharArray(), s1.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    private boolean dfs(char[] firstCompare, char[] secondCompare, char[] sample, int index1, int index2, int index3) {
        if (index3 == sample.length) return true;
        if (index1 == firstCompare.length || firstCompare[index1] != sample[index3]) return false;
        return (dfs(firstCompare, secondCompare, sample, index1 + 1, index2, index3 + 1)
                || dfs(secondCompare, firstCompare, sample, index2, index1 + 1, index3 + 1));
    }
    // Try to not use dfs, failed
    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len3 == 0) return true;
        if (len2 == 0) {
            while(len2 < len1 && s1.charAt(len2) == s3.charAt(len2)) len2++;
            return len2 >= len1;
        }
        if (len1 == 0) {
            while(len1 < len2 && s2.charAt(len1) == s3.charAt(len1)) len1++;
            return len1 >= len2;
        }
        int[] pos2 = new int[len2];
        boolean isFisrt = true;
        for (int i = 0, j = 0, k = 0; i < len3; ) {
            if (isFisrt && k < len2 && s3.charAt(i) == s2.charAt(k)) {
                pos2[k++] = j < len1 && s3.charAt(i) == s1.charAt(j) ? -(i + 1) : (i + 1);
                i++;
            }
            else if (j < len1 && s3.charAt(i) == s1.charAt(j)) {
                j++;
                i++;
                if (!isFisrt) isFisrt = true;
            }
            else {
                while (k > 0 && pos2[--k] >= 0) pos2[k] = 0;
                if (k == 0 && pos2[k] == 0) return false;
                i = -pos2[k] - 1;
                j = i - k;
                pos2[k] = 0;
                isFisrt = false;
            }
        }
        return true;
    }
}
