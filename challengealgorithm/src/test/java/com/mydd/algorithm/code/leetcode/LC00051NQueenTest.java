package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00051NQueenTest {

    @Test
    void solveNQueens() {
        List<String> result1 = new ArrayList<>(Arrays.asList(".Q..","...Q","Q...","..Q."));
        List<String> result2 = new ArrayList<>(Arrays.asList("..Q.","Q...","...Q",".Q.."));
        List<List<String>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        assertEquals(result, new LC00051NQueen().solveNQueens(4));
    }
}