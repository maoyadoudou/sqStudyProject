package com.mydd.algorithm.code.leetcode;

public class LC00057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) return new int[][]{newInterval};
        int i = 0, leftSize, rightSize;

        while (i < len && intervals[i][1] < newInterval[0]) i++;
        // Count unoverlap elements in left side
        leftSize = i;
        // Get min left value of overlap interval
        newInterval[0] = i == len ? newInterval[0] : Math.min(newInterval[0], intervals[i][0]);
        while (i < len && intervals[i][0] <= newInterval[1]) i++;
        // Get max right value of overlap interval
        newInterval[1] = i == 0 ? newInterval[1] : Math.max(newInterval[1], intervals[i - 1][1]);
        // Count unoverlap elements in right side
        rightSize = len - i;

        int[][] res = new int[rightSize + leftSize + 1][];
        System.arraycopy(intervals, 0, res, 0, leftSize);
        res[leftSize] = newInterval;
        System.arraycopy(intervals, len - rightSize, res, leftSize + 1, rightSize);
        return res;
    }
}
