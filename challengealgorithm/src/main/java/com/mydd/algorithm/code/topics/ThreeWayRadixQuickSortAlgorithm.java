package com.mydd.algorithm.code.topics;

import java.util.Collections;
import java.util.List;

public class ThreeWayRadixQuickSortAlgorithm {
    public int[] threeWayRadixQuickSort(List<Integer> inputList) {
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map1 = new ConcurrentHashMap<>();
//        Map<String, String> map2 = new LinkedHashMap<String, String>(1, 0.75F, true);
//        ArrayList arrayList = new ArrayList();
//        LinkedList<Object> linkedList = new LinkedList<>();
//        HashSet<Object> hashSet = new HashSet<>();
        Collections.shuffle(inputList);
        int[] inputArray = inputList.stream().mapToInt(i -> i).toArray();
        sort(inputArray, 0, inputArray.length - 1);
        return inputArray;
    }

    private void sort(int[] inputArray, int lo, int hi) {
        if(lo >= hi) return;
        int cutLeftIndex = lo, cutRightIndex = lo, start = lo + 1, end = hi;
        while(start <= end) {
            if(inputArray[cutLeftIndex] < inputArray[start]) inputArray[start] = inputArray[end] + 0 * (inputArray[end--] = inputArray[start]);
            else if(inputArray[cutLeftIndex] > inputArray[start]) inputArray[start] = inputArray[cutRightIndex++] + 0 * (inputArray[cutLeftIndex++] = inputArray[start++]);
            else {
                cutRightIndex++;
                start++;
            }
        }
        sort(inputArray, lo, cutLeftIndex - 1);
        sort(inputArray, cutRightIndex + 1, hi);
    }
}
