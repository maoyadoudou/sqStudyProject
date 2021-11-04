package com.mydd.algorithm.code.topics;

public class Selection {
    public static int[] sort(int[] input) {
        int len = input.length;
        if (len < 2) return input;
        for(int i = 0; i < len - 2; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (input[i] > input[j]) min = j;
            }
            input[i] = input[min] + 0 * (input[min] = input[i]);
        }
        return input;
    }
}
