package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC00040CombinationSumII {
    List<List<Integer>> result;
    int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        len = candidates.length;
        result = new ArrayList<>();
        if (len == 1 && candidates[0] > target) return result;
        Arrays.sort(candidates);
        assemble(candidates, target, 0, new LinkedList<Integer>());
        return result;
    }

    private void assemble(int[] candidates, int target, int startIndex, LinkedList<Integer> aTeam) {
        if (target == 0) {
            result.add(new ArrayList<>(aTeam));
            return;
        }
        for(int i = startIndex; i < len; i++) {
            if(candidates[i] > target || (i > 0 && candidates[i - 1] == candidates[i])) continue;
            aTeam.add(candidates[i]);
            assemble(candidates, target - candidates[i], i + 1, aTeam);
            aTeam.removeLast();
        }
    }
}
