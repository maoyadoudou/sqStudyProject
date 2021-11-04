package com.mydd.algorithm.code.topics;

public class LSD {
    public String[] sort(String[] a, int w) {
        int len = a.length;
        int R = 256;
        String[] aux = new String[len];
        for(int d = w - 1; d >=0; d--) {
            int[] count = new int[R + 1];
            for(int i = 0; i < len; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for(int i = 1; i < R + 1; i++) {
                count[i] += count[i - 1];
            }
            for(int i = 0; i < len; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for(int i = 0; i < len; i++) {
                a[i] = aux[i];
            }
        }
        return a;
    }
}
