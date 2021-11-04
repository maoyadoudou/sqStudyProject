package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00046PermutationsTest {

    @Test
    void permute() {
        assertEquals(new ArrayList<>(), new LC00046Permutations().permute(new int[]{1,2,3}));
    }
}