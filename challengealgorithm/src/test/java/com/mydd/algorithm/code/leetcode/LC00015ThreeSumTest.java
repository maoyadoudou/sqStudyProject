package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00015ThreeSumTest {

    @Test
    void threeSum() {
        List<List<Integer>> result = new ArrayList();
        assertEquals(result, new LC00015ThreeSum().threeSum(new int[]{-1}));
        assertEquals(result, new LC00015ThreeSum().threeSum(new int[]{}));
//        result.add(Arrays.asList(-1,0,1));
//        assertEquals(result, new ThreeSum().threeSum(new int[]{-1,0,1}));
//        result.add(Arrays.asList(-1,-1,2));
//        assertEquals(result, new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
        result.add(Arrays.asList(0,0,0));
        assertEquals(result, new LC00015ThreeSum().threeSum(new int[]{0,0,0,0}));
    }

    @Test
    void zeroPos() {
        assertEquals(true, new LC00015ThreeSum().zeroPos());
    }
}