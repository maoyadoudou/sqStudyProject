package com.mydd.algorithm.code.topics;

import java.util.Collections;
import java.util.List;

public class QuickSortedAlgorithm {
    public int[] quickSorted(List<Integer> inputList) {
        Collections.shuffle(inputList);
        int[] inputArray = inputList.stream().mapToInt(i -> i).toArray();
        sort(inputArray, 0, inputArray.length - 1);
        System.out.println(inputArray);
        return inputArray;
    }

    private void sort(int[] inputArray, int lo, int hi) {
        if(lo >= hi) return;
        int cutIndex = partition(inputArray, lo, hi);
        sort(inputArray, lo, cutIndex - 1);
        sort(inputArray, cutIndex + 1, hi);
    }

    private int partition(int[] inputArray, int lo, int hi) {
        int cutNum = inputArray[lo], cutIndex = lo;
        for(int i = lo + 1, j = hi; i <= j;) {
            if(inputArray[i] < cutNum) {
                cutIndex++;
                i++;
            } else {
                inputArray[i] = inputArray[j] + 0 * (inputArray[j] = inputArray[i]);
                j--;
            }
        }
        inputArray[cutIndex] = inputArray[lo] + 0 * (inputArray[lo] = inputArray[cutIndex]);
        return cutIndex;
    }
}
