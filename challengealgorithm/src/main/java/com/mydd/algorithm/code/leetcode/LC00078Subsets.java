package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00078Subsets {
    List<List<Integer>> result;
    int len;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        Integer[] numsBox = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        result.add(new ArrayList<Integer>(Arrays.asList(numsBox)));
        len = nums.length;
        if (len == 0) return result;
        result.add(new ArrayList<>());
        for (int i = 1; i <= len / 2; i++) {
            backTrace(numsBox, i, 0, new Integer[i], new Integer[len - i], 0);
        }
        return result;
    }

    private void backTrace(Integer[] nums, int k, int start, Integer[] aResult, Integer[] another, int index) {
        if (k == 0) {
            result.add(new ArrayList<>(Arrays.asList(aResult)));
            for (int i = start; i < len; i++) another[index + i - start] = nums[i];
            if (another.length != aResult.length) result.add(new ArrayList<>(Arrays.asList(another)));
            return;
        }
        aResult[k - 1] = nums[start];
        backTrace(nums, k - 1, start + 1, aResult, another, index);
        for (int i = start + 1; i < len - k + 1; i++) {
            another[index + i - start - 1] = nums[i - 1];
            aResult[k - 1] = nums[i];
            backTrace(nums, k - 1, i + 1, aResult, another, index + i - start);
        }
    }
}
