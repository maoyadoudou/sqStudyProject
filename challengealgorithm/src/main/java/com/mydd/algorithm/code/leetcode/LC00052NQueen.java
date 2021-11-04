package com.mydd.algorithm.code.leetcode;

public class LC00052NQueen {
    int result = 0;
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;
        byte[] qArray = new byte[n];
        for (byte i = 0; i < n; i++) {
            qArray[0] = i;
            dfs(qArray, n, (byte) 1);
        }
        return result;
    }

    private void dfs(byte[] qArray, int n, byte nextI) {
        if (nextI == n) {
            result++;
            return;
        }

        for (byte j = 0; j < n; j++) {
            boolean nextPoint = true;
            for (byte i = 0; i < nextI && nextPoint; i++) {
                nextPoint &= canInsert(qArray[i], i, j, nextI);
            }
            if (nextPoint) {
                qArray[nextI] = j;
                dfs(qArray, n, (byte) (nextI + 1));
            }
        }

    }

    private boolean canInsert(byte oldI, byte oldJ, byte newI, byte newJ) {
        int diffx = (oldI - newI), diffy = (oldJ - newJ);
        return diffx != diffy && diffx != -diffy && (diffx * diffy > 1 || diffx * diffy < -1);
    }
}
