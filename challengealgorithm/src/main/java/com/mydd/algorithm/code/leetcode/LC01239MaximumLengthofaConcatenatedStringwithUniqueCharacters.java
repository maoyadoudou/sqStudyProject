package com.mydd.algorithm.code.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LC01239MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    int max = 0, len;
    LinkedList<String> list;
    public int maxLength(List<String> arr) {
        Iterator<String> iter = arr.iterator();
        while(iter.hasNext()) {
            String item = iter.next();
            if(item.length() > 26) {
                iter.remove();
                continue;
            }
            for(char ch : item.toCharArray()) {
                if(item.indexOf(ch) != item.lastIndexOf(ch)) {
                    iter.remove();
                    break;
                }
            }
        }
        len = arr.size();
        if(len == 1) return arr.get(0).length();
        list = new LinkedList<>();
        concatenate(0, arr, 0);
        return max;
    }

    private void concatenate(int index, List<String> arr, int clen) {
        max = Math.max(max, clen);
        for(int i = index; i < len && max < 26; i++) {
            if(clen + arr.get(i).length() > 26) continue;
            if(isDiff(arr.get(i))){
                list.addLast(arr.get(i));
                concatenate(i + 1, arr, clen + arr.get(i).length());
                list.removeLast();
            }
        }
    }

    private boolean isDiff(String str) {
        for(char ch : str.toCharArray()) {
            for(String strEle : list) {
                if (strEle.indexOf(ch) > -1) return false;
            }
        }
        return true;
    }
}
