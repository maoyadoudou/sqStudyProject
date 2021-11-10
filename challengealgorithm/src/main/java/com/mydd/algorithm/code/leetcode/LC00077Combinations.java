package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00077Combinations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        for (int i = 1; i <= n - k + 1; i++) {
            Integer[] nums = new Integer[k];
            nums[0] = i;
            assemble(nums, i + 1, n, k - 1, 1);
        }
        return result;
    }

    private void assemble(Integer[] nums, int start, int n, int k, int index) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(Arrays.asList(nums)));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            nums[index] = i;
            assemble(nums, i + 1, n, k - 1, index + 1);
        }
    }
}
