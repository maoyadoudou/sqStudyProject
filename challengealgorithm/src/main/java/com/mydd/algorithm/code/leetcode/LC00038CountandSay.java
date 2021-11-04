package com.mydd.algorithm.code.leetcode;

public class LC00038CountandSay {
    public String countAndSay(int n) {
        return sayN(n).toString();
    }

    private StringBuilder sayN(int n) {
        if(n > 1) {
            StringBuilder sb = sayN(n - 1);
            int num = 1, len = sb.length();
            char a[] = new char[len];
            sb.getChars(0, len, a, 0);
            sb.setLength(0);
            for(int i = 1; i < len; i++) {
                if(a[i] == a[i - 1]) {
                    num++;
                } else {
                    sb.append(num).append(a[i - 1]);
                    num = 1;
                }
            }
            sb.append(num).append(a[len - 1]);
            return sb;
        } else {
            return new StringBuilder().append("1");
        }
    }
}
