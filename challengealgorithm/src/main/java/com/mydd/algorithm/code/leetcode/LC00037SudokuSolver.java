package com.mydd.algorithm.code.leetcode;

public class LC00037SudokuSolver {
    boolean[][] dp;
    int[][] sudoku;
    public void solveSudoku(char[][] board) {
        dp = new boolean[9][9];
        sudoku = new int[9][9];
        int tmp = (1 << 9) - 1, mtxIdx;
        int[] row = new int[]{tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp},
              col = new int[]{tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp},
              mtx = new int[]{tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp};
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                tmp = board[i][j] - '0';
                sudoku[i][j] = tmp;
                dp[i][j] = tmp > 0;
                if (tmp > 0) {
                    tmp = 1 << (tmp - 1);
                    row[i] = row[i] ^ tmp;
                    col[j] = col[j] ^ tmp;
                    mtxIdx = (i / 3) * 3 + j / 3;
                    mtx[mtxIdx] = mtx[mtxIdx] ^ tmp;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (!dp[i][j]) {
                    mtxIdx = (i / 3) * 3 + j / 3;
                    sudoku[i][j] = row[i] & col[j] & mtx[mtxIdx];
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (!dp[i][j]) {
                    mtxIdx = (i / 3) * 3 + j / 3;
                    sudoku[i][j] = row[i] & col[j] & mtx[mtxIdx];
                }
            }
        }

        fun(board);
    }

    private boolean fun(char[][] board) {
        int i, j = 0;
        boolean flag = false;
        for(i = 0; i < 9; i++) {
            for(j = 0; j < 9; j++) {
                if(!dp[i][j]) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        if(i == 9 && j == 9) return true;

        for(int e = 1; e <= 9; e++) {
            if(isSingleDecimal(sudoku[i][j] & (1 << (e - 1))) < 0) continue;
            if(valid(board, i, j, e)) {
                dp[i][j] = true;
                board[i][j] = (char)(e + '0');
                if(fun(board)) return true;
                board[i][j]='.';
                dp[i][j] = false;
            }
        }
        return false;
    }

    private boolean valid(char[][] board, int row, int col, int e)
    {
        char p = (char)(e + '0');
        for(int i = 0; i < 9; i++) {
            if (board[row][i] == p) return false;
        }
        for(int i = 0; i < 9; i++) {
            if (board[i][col] == p) return false;
        }

        row = row - row % 3;
        col = col - col % 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[row+i][col+j] == p) return false;
            }
        }
        return true;
    }

    private int isSingleDecimal(int n) {
        switch(n) {
            case 1: return 1;
            case 2: return 2;
            case 4: return 3;
            case 8: return 4;
            case 16: return 5;
            case 32: return 6;
            case 64: return 7;
            case 128: return 8;
            case 256: return 9;
            default:  return -1;
        }
    }


}
