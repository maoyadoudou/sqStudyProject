package com.mydd.algorithm.code.leetcode;

public class LC00036ValidSudoku {
    byte[][] horizon = new byte[9][9];
    byte[][] vertical = new byte[9][9];
    byte[][] group = new byte[9][9];
    public boolean isValidSudoku(char[][] board) {
        // exam
        if (!isValidPre(board)) return false;
        else return true;
        // repeat test new case
//        return repeatTestNewCase(board, 0, 0);
    }

    private boolean isValidPre(char[][] board) {
        int value, num;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    value = board[i][j] - '1';
                    num = (i / 3) * 3 + j / 3;
                    if (horizon[i][value] > 0 || vertical[j][value] > 0 || group[num][value] > 0) return false;
                    else {
                        horizon[i][value]++;
                        vertical[j][value]++;
                        group[num][value]++;
                    }
                }
            }
        }
        return true;
    }

    private boolean repeatTestNewCase(char[][] board, int i, int j) {
        if (i == 9) return true;
        System.out.println(i + " " + j);
        if (board[i][j] != '.') {
            return repeatTestNewCase(board, i + j / 8, (j + 1) % 9);
        } else {
            return checkNewValue(board, i, j);
        }
    }

    private boolean checkNewValue(char[][] board, int i, int j) {
        int num = (i / 3) * 3 + j / 3, nextI = i + j / 8, nextJ = (j + 1) % 9;
        for(int insertNum = 0; insertNum < 9; insertNum++) {
            if (horizon[i][insertNum] > 0 || vertical[j][insertNum] > 0 || group[num][insertNum] > 0) continue;

            horizon[i][insertNum]++;
            vertical[j][insertNum]++;
            group[num][insertNum]++;
            if (repeatTestNewCase(board, nextI, nextJ)) return true;
            horizon[i][insertNum]--;
            vertical[j][insertNum]--;
            group[num][insertNum]--;
        }
        return false;
    }
}
