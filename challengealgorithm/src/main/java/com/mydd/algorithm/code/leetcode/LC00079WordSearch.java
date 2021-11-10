package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC00079WordSearch {
    int rowLen, colLen, wordLen;
    char[] wordChars;
    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        if (rowLen == 0) return false;
        colLen = board[0].length;
        wordLen = word.length();
        if (wordLen > rowLen * colLen) return false;
        wordChars = word.toCharArray();
        boolean[][] path = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
//                if (board[i][j] == wordChars[0]) {
//                    path[i][j] = true;
                    if (findWord(board, path, i, j, 0)) return true;
//                    path[i][j] = false;
//                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, boolean[][] path, int row, int col, int index) {
        if (index == wordLen) return true;
        if (row < 0 || row == rowLen || col < 0 || col == colLen || path[row][col] || !(board[row][col] == wordChars[index])) return false;
        path[row][col] = true;
        if (findWord(board, path, row - 1, col, index + 1)
           || findWord(board, path, row + 1, col, index + 1)
           || findWord(board, path, row, col - 1, index + 1)
           || findWord(board, path, row, col + 1, index + 1))
            return true;
        path[row][col] = false;
        return false;
//        if (row > 0 && !path[row - 1][col] && board[row - 1][col] == wordChars[index]) {
//            path[row - 1][col] = true;
//            if (findWord(board, path, row - 1, col, index + 1)) return true;
//            path[row - 1][col] = false;
//        }
//        if (row < rowLen - 1 && !path[row + 1][col] && board[row + 1][col] == wordChars[index]) {
//            path[row + 1][col] = true;
//            if (findWord(board, path, row + 1, col, index + 1)) return true;
//            path[row + 1][col] = false;
//        }
//        if (col > 0 && !path[row][col - 1] && board[row][col - 1] == wordChars[index]) {
//            path[row][col - 1] = true;
//            if (findWord(board, path, row, col - 1, index + 1)) return true;
//            path[row][col - 1] = false;
//        }
//        if (col < colLen - 1 && !path[row][col + 1] && board[row][col + 1] == wordChars[index]) {
//            path[row][col + 1] = true;
//            if (findWord(board, path, row, col + 1, index + 1)) return true;
//            path[row][col + 1] = false;
//        }
//        return false;
    }
}
