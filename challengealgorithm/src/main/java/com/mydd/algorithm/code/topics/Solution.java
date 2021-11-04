package com.mydd.algorithm.code.topics;

import java.util.*;

class Solution extends AbstractList {
    String [] sa;
    List<List<String>> lls = null;

    public List<List<String>> groupAnagrams(String[] strs) {
        sa = strs;
        return this;
    }

    @Override
    public List<String> get(int idx) {
        if (lls == null) {
            System.out.println("get为null" + idx);
            makeList();
        }
        return lls.get(idx);
    }

    @Override
    public int size() {
        if (lls == null) {
            System.out.println("size为null");
            makeList();
        }
        return lls.size();
    }

    public void makeList() {
        Map<int [], List<String>> m = new TreeMap<>(new Comparator<int []>() {
            @Override public int compare(int [] a, int [] b) {
                System.out.println("比较");
                for (int i = 0; i < 26; i++) if (a[i] != b[i]) { return (a[i] - b[i]); }
                return 0;
            }
        });

        for (String s : sa) {
            int [] cc = countChars(s);
            List<String> l = m.get(cc);
            if (l == null) { l = new ArrayList<>(); m.put(cc, l); }
            l.add(s);
        }
        System.out.println("插入lls");
        lls = new ArrayList<>(m.values());
    }

    private int [] countChars(String s) {
        int [] cc = new int [26];
        for (char c : s.toCharArray()) cc[c - 'a']++;
        return cc;
    }
}