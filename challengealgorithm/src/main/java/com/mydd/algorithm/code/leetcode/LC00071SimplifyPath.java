package com.mydd.algorithm.code.leetcode;

import java.util.Stack;

public class LC00071SimplifyPath {
    public String simplifyPath(String path) {
        int len = path.length();
        if (len < 2) return path;
        Stack<Integer> pos = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // path start with slash
        pos.push(1);
        sb.append(path.charAt(0));
        int dot = 0;
        for (int i = 1; i < len; i++) {
            if (path.charAt(i) == '/') {
                // exclude double slash
                if (path.charAt(i - 1) == '/') continue;
                if (dot < 1) {
                    dot = 0;
                    sb.append(path.charAt(i));
                    pos.push(sb.length());
                    continue;
                }
                // exclude dot slash and double dot slash
                if (dot == 2 && pos.size() > 1) pos.pop();
                sb.setLength(pos.peek());
                dot = 0;
            } else {
                sb.append(path.charAt(i));
                if (path.charAt(i) != '.' || dot == 2) dot = -1;
                else if (dot > -1) dot++;
            }
        }
        // consider end with /. or /..
        // exclude dot slash
//        for (int i = sb.length() - 1; i > 0; i--) {
//            if (sb.charAt(i) == '/') {
//                sb.setLength(i);
//                continue;
//            } else break;
//        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') sb.setLength(sb.length() - 1);
        if (dot == 1) {
            sb.setLength(Math.max(pos.peek() - 1, 1));
        }
        // exclude dot dot slash
        if (dot == 2) {
            if (pos.size() > 1) pos.pop();
            sb.setLength(Math.max(pos.peek() - 1, 1));
        }

        return sb.toString();
    }
}
