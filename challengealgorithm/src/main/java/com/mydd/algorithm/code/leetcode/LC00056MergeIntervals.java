package com.mydd.algorithm.code.leetcode;

import java.util.*;

public class LC00056MergeIntervals {
    int[][] aux;
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) return intervals;
        aux = new int[len][];
        sort(intervals, 0, len - 1);
        List<int[]> list = new ArrayList<>();
        for (int[] pairs : intervals) {
            int len1 = list.size();
            if (len1 == 0 || list.get(len1 - 1)[1] < pairs[0]) {
                list.add(pairs);
            } else {
                list.get(len1 - 1)[1] = Math.max(pairs[1], list.get(len1 - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private void sort(int[][] intervals, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(intervals, lo, mid);
        sort(intervals, mid + 1, hi);
        merge(intervals, lo, mid, hi);
    }

    private void merge(int[][] intervals, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) aux[i] = intervals[i];

        for (int k = lo, i = lo, j = mid + 1; k <= hi;) {
            if (i > mid) intervals[k++] = aux[j++];
            else if (j > hi) intervals[k++] = aux[i++];
            else if (aux[i][0] > aux[j][0]) intervals[k++] = aux[j++];
            else intervals[k++] = aux[i++];
        }
    }
}
