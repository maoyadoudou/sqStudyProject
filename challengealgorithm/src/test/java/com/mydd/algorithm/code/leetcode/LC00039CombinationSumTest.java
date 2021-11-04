package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00039CombinationSumTest {

    @Test
    void combinationSum() {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,2)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,3)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,1,2,2)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,1,4)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,2,3)));
        res.add(new ArrayList<>(Arrays.asList(1,1,1,5)));
        res.add(new ArrayList<>(Arrays.asList(1,1,2,2,2)));
        res.add(new ArrayList<>(Arrays.asList(1,1,2,4)));
        res.add(new ArrayList<>(Arrays.asList(1,1,3,3)));
        res.add(new ArrayList<>(Arrays.asList(1,1,6)));
        res.add(new ArrayList<>(Arrays.asList(1,2,2,3)));
        res.add(new ArrayList<>(Arrays.asList(1,2,5)));
        res.add(new ArrayList<>(Arrays.asList(1,3,4)));
        res.add(new ArrayList<>(Arrays.asList(1,7)));
        res.add(new ArrayList<>(Arrays.asList(2,2,2,2)));
        res.add(new ArrayList<>(Arrays.asList(2,2,4)));
        res.add(new ArrayList<>(Arrays.asList(2,3,3)));
        res.add(new ArrayList<>(Arrays.asList(2,6)));
        res.add(new ArrayList<>(Arrays.asList(3,5)));
        res.add(new ArrayList<>(Arrays.asList(4,4)));
        res.add(new ArrayList<>(Arrays.asList(8)));

        assertEquals(res, new LC00039CombinationSum().combinationSum(new int[]{1,2,3,4,5,6,7,8}, 8));
    }
}