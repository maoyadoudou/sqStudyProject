package com.mydd.algorithm.code.leetcode;

enum Result44{
    TRUE, FALSE
}

public class LC00044WildcardMatching {
    Result44[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Result44[s.length() + 1][p.length() + 1];
        dp[0][0] = Result44.TRUE;
        return pMatch(s, p, 0, 0);
    }

    private boolean pMatch(String s, String p, int sIndex, int pIndex) {
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }
        if(sIndex == s.length()) {
            while(pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
            return pIndex == p.length();
        }
        if(dp[sIndex + 1][pIndex + 1] != null) {
            return dp[sIndex + 1][pIndex + 1] == Result44.TRUE;
        } else {
            boolean res = (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex));
            if (res) {
                res = pMatch(s, p, sIndex + 1, pIndex + 1);
            } else if (p.charAt(pIndex) == '*') {
                res = pMatch(s, p, sIndex, pIndex + 1) || pMatch(s, p, sIndex + 1, pIndex) ;
            }
            dp[sIndex + 1][pIndex + 1] = res ? Result44.TRUE : Result44.FALSE;
            return res;
        }
    }

    private boolean pMatch1(String s, String p, int sIndex, int pIndex) {
        int startIdx = -1, match =-1;
        while(sIndex < s.length()) {
            if((pIndex < p.length()) && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))){
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                match = pIndex;
                startIdx = sIndex;
                pIndex++;
            } else if (startIdx != -1) {
                startIdx += 1;
                sIndex = startIdx;
                pIndex = match + 1;
            } else {
                return false;
            }
        }
        while(pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
        return pIndex == p.length();
    }
}
