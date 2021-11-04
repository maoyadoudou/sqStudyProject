package com.mydd.algorithm.code.leetcode;

public class LC00085MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int len1 = matrix.length;
        int len2 = len1 == 0 ? 0 : matrix[0].length;
        if (len2 == 0) return 0;
        int[][] dp = new int[len1][len2];
        for(int i = 0; i < len1; i++) {
            for(int j = len2 - 1; j >= 0; j--) {
                dp[i][j] = matrix[i][j] - '0';
                if (j < len2 - 1 && dp[i][j] == 1) dp[i][j] += dp[i][j + 1];
            }
        }
        int max = 0, minW, h;
        for(int j = 0; j < len2; j++) {
            for(int i = 0; i < len1; i++) {
                if(dp[i][j] == 0 || (i > 0 && dp[i - 1][j] == dp[i][j])) continue;
                minW = dp[i][j];
                h = 0;
                for(int k = i; k < len1; k++) {
                    h++;
                    if (k + 1 < len1 && dp[k][j] > 0 && dp[k + 1][j] >= dp[k][j]) {
                        continue;
                    }
                    max = Math.max(max, minW * (h));
                    if (k + 1 == len1) break;
                    minW = Math.min(minW, dp[k + 1][j]);
                    if(minW == 0) break;
                }
            }
        }
        String a = "abac";
        return max;
    }
}
