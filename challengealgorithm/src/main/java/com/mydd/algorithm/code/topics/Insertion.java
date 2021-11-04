package com.mydd.algorithm.code.topics;

public class Insertion {
    public static int[] sort(int[] input) {
        int len = input.length;
        if (len < 2) return input;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && input[j + 1] < input[j]; j--) {
                input[j + 1] = input[j] + 0 * (input[j] = input[j + 1]);
            }
        }
        return input;
    }
}
