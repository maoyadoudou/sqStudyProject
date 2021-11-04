package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00051NQueen {
    ArrayList<List<String>> result;
    char[] line;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 1) {
            result.add(new ArrayList<String>(Arrays.asList("Q")));
            return result;
        }
        if (n < 4) {
            return result;
        }
        line = new char[n];
        Arrays.fill(line, '.');
        byte[] qArray = new byte[n];
        for (byte i = 0; i < n; i++) {
            qArray[0] = i;
            dfs(qArray, n, (byte) 1);
        }
        return result;
    }

    private void dfs(byte[] qArray, int n, byte nextI) {
        if (nextI == n) {
            List<String> aResult = new ArrayList<>();
            for (byte i = 0; i < n; i++) {
                char[] tmp = line.clone();
                tmp[qArray[i]] = 'Q';
                aResult.add(new String(tmp));
            }
            result.add(aResult);
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
