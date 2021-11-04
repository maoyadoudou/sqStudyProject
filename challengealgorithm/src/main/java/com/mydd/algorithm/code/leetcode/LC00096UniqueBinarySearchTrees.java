package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00096UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;
        List<Integer> cbnt = new ArrayList<>();
        // n=1
        cbnt.add(1);
        // n=2
        cbnt.add(2);
        // n=3
        cbnt.add(5);
        int left, counter, j, mid;
        for(int i = 3; i < n; i++) {
            left = i - 1;
            counter = cbnt.get(left);
            j = 1;
            mid = (i + 1) / 2;
            for(j = 1; j < mid; j++) {
                counter += cbnt.get(left - j) * cbnt.get(j - 1);
            }
            counter *= 2;
            if(i % 2 == 0 && j == mid) {
                counter += cbnt.get(left - j) * cbnt.get(j - 1);
            }
            cbnt.add(counter);
        }
        return cbnt.get(n - 1);
    }
}
