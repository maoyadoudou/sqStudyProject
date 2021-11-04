package com.mydd.algorithm.code.topics;

public class MSD {
    int R = 256;
    String[] aux;
    public String[] sort(String[] a) {
        int len = a.length;
        aux = new String[len];
        sort(a, 0, len - 1, 0);
        return a;
    }

    private void sort(String[] a, int lo, int hi, int index) {

        if(hi < lo) return;
        int[] count = new int[R + 2];
        for(int i = lo; i <= hi; i++) {
            count[charAt(a[i], index) + 2]++;
        }
        for(int i = 1; i < R + 2; i++) {
            count[i] += count[i - 1];
        }
        for(int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], index) + 1]++] = a[i];
        }
        for(int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        for(int i = 0; i < R; i++) {
            sort(a, lo + count[i], lo + count[i + 1] - 1, index + 1);
        }
    }

    private int charAt(String str, int index) {
        return index >= str.length() ? -1 : str.charAt(index);
    }
}
