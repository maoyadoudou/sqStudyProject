package com.mydd.algorithm.code.leetcode;

import java.util.Stack;

public class LC00020ValidParentheses {
    Stack<String> sk;
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        sk = new Stack();
        for(char item : s.toCharArray()) {
            if(putStack(String.valueOf(item))) continue;
            return false;
        }
        return sk.size() == 0;
    }

    private boolean putStack(String s) {
        switch(s) {
            case "(" : sk.push(")");
                return true;
            case "[" : sk.push("]");
                return true;
            case "{" : sk.push("}");
                return true;
            case ")" :
            case "]" :
            case "}" :
                return sk.size() > 0 && s.equals(sk.pop());
        }
        return false;
    }
}
