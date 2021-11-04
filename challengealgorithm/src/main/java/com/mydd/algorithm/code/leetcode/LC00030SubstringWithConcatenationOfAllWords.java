package com.mydd.algorithm.code.leetcode;

import java.util.*;

public class LC00030SubstringWithConcatenationOfAllWords {
    int wLen, unitLen, seqLen, sLen;
    String tmp;
    List<Integer> res;
    Map<String, LinkedList<Integer>> wordsMap;
    public List<Integer> findSubstringIndex(String s, String[] words) {
        res = new ArrayList();
        sLen = s.length();
        wLen = words.length;
        unitLen = words[0].length();
        seqLen = wLen * unitLen;
        if (sLen < seqLen) return res;

        wordsMap = new HashMap();
        for(String word : words) {
            if(wordsMap.get(word) == null) {
                LinkedList<Integer> a = new LinkedList();
                a.addLast(-1);
                wordsMap.put(word, a);
            } else {
                wordsMap.get(word).addLast(-1);
            }
        }
        return findSubstringIndex(s);
    }

    private int findNextStartPoint(String s, int index) {
        for(int i = index, j = index + unitLen; j <= sLen; i++, j++) {
            if(wordsMap.get(s.substring(i, j)) != null) return i;
        }
        return -1;
    }

    private List<Integer> findSubstringIndex(String s) {
        boolean flag = true, record = false;
        int len;
        int startIndex;
        for(int step = 0; step < unitLen; step++) {
            startIndex = step;
            for(int i = startIndex, j = i + unitLen; j <= sLen; i += unitLen, j += unitLen) {
                tmp = s.substring(i, j);
                Integer prevIdx = wordsMap.get(tmp) == null ? null : wordsMap.get(tmp).pollFirst();
                if (prevIdx == null) {
                    if(record && i - startIndex == seqLen) res.add(startIndex);
                    record = false;
                    flag = true;
                    continue;
                }
                if(flag) {
                    startIndex = i;
                    record = true;
                    flag = false;
                }
                if(startIndex > prevIdx || prevIdx == -1) {
                    wordsMap.get(tmp).addLast(i);
                    if(j > sLen - unitLen && j - startIndex == seqLen) res.add(startIndex);
                    continue;
                }
                if(j - prevIdx <= seqLen) {
                    if(i - startIndex == seqLen) res.add(startIndex);
                    startIndex = prevIdx + unitLen;
                } else {
                    res.add(startIndex);
                    startIndex += unitLen;
                    if(j > sLen - unitLen && j - startIndex == seqLen) res.add(startIndex);
                }
                wordsMap.get(tmp).addLast(i);
            }
            if (step < unitLen - 1) {
                Iterator<LinkedList<Integer>> iter = wordsMap.values().iterator();
                while(iter.hasNext()) {
                    LinkedList<Integer> next = iter.next();
                    len = next.size();
                    while(len-- >= 0) {
                        next.pollFirst();
                        next.addLast(-1);
                    }
                }
            }
        }
        return res;
    }
}
