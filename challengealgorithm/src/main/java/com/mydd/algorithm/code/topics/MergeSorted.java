package com.mydd.algorithm.code.topics;

import java.util.List;

public class MergeSorted {
    int[] aux;
    public Boolean MergeSortedAlgorithm(List<Integer> inputList) {
        aux = new int[inputList.size()];
        int[] inputArray = ListToIntArray(inputList);
        sort(inputArray, 0, inputList.size() - 1);
        System.out.println(inputArray);
        return true;
    }

    private int[] ListToIntArray(List<Integer> inputList) {
        return inputList.stream().mapToInt(i -> i).toArray();
    }

    private void sort(int[] arrays, int lo, int hi) {
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2, start = lo, end = hi;
        sort(arrays, start, mid);
        sort(arrays, mid + 1, end);
        merge(arrays, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int i = start, j = mid + 1;
        for(int k = start; k <= end; k++) aux[k] = array[k];

        for(int k = start; k <= end; k++) {
            if(i > mid) array[k] = aux[j++];
            else if (j > end) array[k] = aux[i++];
            else if(aux[i] > aux[j]) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }
}
