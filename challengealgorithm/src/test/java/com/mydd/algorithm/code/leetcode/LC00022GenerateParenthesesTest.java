package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00022GenerateParenthesesTest {

    @Test
    void generateParenthesis() {
        List<String> res = new ArrayList<>();
        res.add("((()))");
        res.add("(()())");
        res.add("(())()");
        res.add("()(())");
        res.add("()()()");
        assertEquals(res, new LC00022GenerateParentheses().generateParenthesis(3));
        res = new ArrayList<>();
        res.add("()");
        assertEquals(res, new LC00022GenerateParentheses().generateParenthesis(1));
    }
}