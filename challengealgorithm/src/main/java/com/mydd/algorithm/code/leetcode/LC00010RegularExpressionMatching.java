package com.mydd.algorithm.code.leetcode;

enum Result{
    T, F
}


public class LC00010RegularExpressionMatching {

    public boolean compareCh() {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        return true;
    }
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if(lenP == 0) {
            return lenS == 0;
        }
        boolean firstMatch  = lenS > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (lenP > 1 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    public boolean isMatchDP(String s, String p) {
        // After reading the Solution and Discuss
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = Boolean.TRUE;
        for (int i = 1; i < lenP - 1; i += 2) {
            if(p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        char tmpS, tmpP;
        for (int i = 0; i < lenS; i++) {
            tmpS = s.charAt(i);
            for(int j = 0; j < lenP; j++) {
                tmpP = p.charAt(j);
                if (tmpP == '.' || tmpP == tmpS) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (tmpP == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[lenS][lenP];
    }
    Result[][] r;
    public boolean isMatchDP1(String s, String p) {
        // After reading the Solution and Discuss
        int lenS = s.length();
        int lenP = p.length();
        r = new Result[lenS + 1][lenP + 1];
        return dp(s, p, 0, 0, lenS, lenP);
    }

    public boolean dp(String s, String p, int i, int j, int lenS, int lenP) {
        if(r[i][j] != null) {
            return r[i][j] == Result.T;
        } else {
            boolean a;
            if(j == lenP) {
                return i == lenS;
            } else {
                boolean firstMatch  = i < lenS && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
                if (j + 1 < lenP && p.charAt(j + 1) == '*') {
                    a = (firstMatch && dp(s, p, ++i, j, lenS, lenP)) || dp(s, p, i, j + 2, lenS, lenP);
                } else {
                    a = firstMatch && dp(s, p, ++i, ++j, lenS, lenP);
                }
            }
            r[i][j] = a ? Result.T : Result.F;
            return a;
        }
    }



    public boolean isMatch1(String s, String p) throws Exception {
        // clear tail
        int lenS = s.length(), lenP = p.length();
        int endP = lenP - 1, endS = lenS - 1;
        boolean isDiff = false;
        while(endP > -1 && endS > -1) {
            if(p.charAt(endP) == '.' || p.charAt(endP) == s.charAt(endS)) {
                endP--;
                endS--;
                continue;
            }
            if(p.charAt(endP) == '*') {
                if(p.charAt(endP - 1) != '.' && endS > 0 && s.charAt(endS) != s.charAt(endS - 1)) {
                    endP -= 2;
                    endS -= 2;
                    continue;
                }
                isDiff = true;
                break;
            } else {
                return false;
            }
        }
        if(isDiff) {
            isDiff = false;
        } else {
            return endP == endS;
        }
        // clear head
        endP++;
        endS++;
        int startP = 0, startS = 0;
        while(startP < endP && startS < endS) {
            if(p.charAt(startP) == '*') {
                if (p.charAt(startP) != '.' && s.charAt(startS) != s.charAt(startS - 1)) {
                    startP++;
                    startS--;
                    continue;
                }
                isDiff = false;
                startP--;
                startS--;
                break;
            }
            if(isDiff) {
                return false;
            }
            if(p.charAt(startP) == '.' || p.charAt(startP) == s.charAt(startS)) {
                startP++;
                startS++;
                continue;
            }
            isDiff = true;
        }
        // deal with the rest lenP = 2
        lenS = endS - startS;
        lenP = endP - startP;
        int i = startS;
        char tmpChar;
        if (lenP == 2) {
            if (lenS == 1) {
                return false;
            }
            if (lenS == 0) {
                return true;
            }
            tmpChar = p.charAt(startP);
            if (tmpChar == '.') {
                return true;
            }
            while(i < endS) {
                if (tmpChar != s.charAt(i++)) {
                    return false;
                }
            }
            return true;
        }
        s = s.substring(startS, endS);
        p = p.substring(startP, endP);
        return trimStr(p, s);




//        int result = lenP + lenS - start << 2;
//        if(result == 0) {
//            return isDiff;
//        }
//
//        p = p.substring(start, endP + 1);
//        s = s.substring(start, endS + 1);
//        lenS = endS + 1 - start;
//        lenP = endP + 1 - start;
//
//
//
//        char ch = p.charAt(0);
//        boolean flag = ch == '.' || ch == s.charAt(0);
//        if (!flag) {
//            return false;
//        }
//        if (lenP == 1) {
//            return lenS == 1;
//        }
//        int start = 0, end = 1;
//        int i = 1, j = 1;
//        char prev, next;
//        flag = ch == '.';
//        if (flag) { // flag is true when locate in placehold zone
//            start = p.charAt(1) == '*' ? 2 : 1;
//        }
//        for(i = start; i < lenP; i++) {
//            if (flag) {
//                if (p.charAt(i) == '.' || p.charAt(i) == '*') {
//                    continue;
//                }
//                if (p.charAt(i + 1) == '*') {
//                    i++;
//                    continue;
//                }
//                start = i;
//                flag = false;
//            }
//            if (!flag) {
//                if (p.charAt(i) == '.') {
//                    flag = true;
//                    end = i;
//                }
//                if (p.charAt(i) == '*') {
//                    flag = true;
//                    if (i - start < 2) {
//                        continue;
//                    }
//                    end = i - 1;
//                }
//                if (end > start) {
//
//                }
//                continue;
//            }
//            if (flag && start != end) {
//
//            }
//        }
//        for(; i < lenS && j < lenP;) {
//            if (s.charAt(i) == p.charAt(j)) {
//                continue;
//            }
//            if (p.charAt(j) == '.') {
//                continue;
//            }
//            if (p.charAt(j) == '*') {
//
//            }
//
//        }
//        return true;
    }

    public boolean trimStr(String p, String s) throws Exception {
        int pos = trimStr1(p, s);
        int len = s.length();
        if (len == pos) {
            return true;
        } else if (len - pos == 1) {
            return false;
        } else if (len - pos > 1) {
            char tail = p.charAt(p.length() - 2);
            int i = pos;
            while(i < len) {
                if (tail != s.charAt(pos)) {
                    return false;
                }
            }
            return true;
        } else {
            throw new Exception("pos out the bound of s");
        }
    }

    public int trimStr1(String p, String s) {
        if (p.length() == 2) {
            int len = s.length();
            if (len == 0) return 0;
            if (len == 1) return -1;
            int i = len - 1;
            char head = p.charAt(i);
            if (s.charAt(len - 2) != s.charAt(len - 1) || head != s.charAt(len - 1)) return -len;
            while(i > -1) {
                if (head != s.charAt(i--)) {
                    return -1;
                }
            }
            return len;
        }
        String subStr = findSubStr(p);
        int subLen = subStr.length();
        int[][] dfa;
        int offset;
        dfa = KMP(subStr);
        offset = search(s, dfa, subStr.length());
        char head = p.charAt(0);
        if (offset == 1 || offset == s.length()) { return -1;}
        int result;
        if (offset == 0) {
            result = trimStr1(p.substring(subLen + 2), s.substring(offset + subLen));
        } else {
            if (head == '.') {
                result = trimStr1(p.substring(subLen + 2), s.substring(offset + subLen));
            } else {
                int i = 0;
                while(i < offset) {
                    if (head != s.charAt(i)) {
                        return -1;
                    }
                }
                result = trimStr1(p.substring(subLen + 2), s.substring(offset + subLen));
            }
        }
        return result == -1 ? -1 : offset + subLen + result;
    }

    public String findSubStr(String p) {
        int i = 2;
        int len = p.length();
        while(i < len) {
            if(p.charAt(i++) == '*') {
                break;
            }
        }
        return p.substring(2, i - 1);
    }

    public int[][] KMP(String pat) {
        int R = 26;
        int n = pat.length();
        int[][] dfa = new int[R][n];
        char tempCh = pat.charAt(0);
        if (tempCh == '.') {
            for(int i = 0; i < R; i++) {
                dfa[i][0] = 1;
            }
        } else {
            dfa[tempCh - 'a'][0] = 1;
        }
        for(int X = 0, j = 1; j < n; j++) {
            for(int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            tempCh = pat.charAt(j);
            if (tempCh == '.') {
                for(int i = 0; i < R; i++) {
                    dfa[i][j] = j + 1;
                }
                tempCh = 'a';
            } else {
                dfa[tempCh - 'a'][j] = j + 1;
            }
            X = dfa[tempCh - 'a'][X];
        }
        return dfa;
    }

    public int search(String s, int[][] dfa, int patLen){
        int len = s.length();
        int index, i, j;
        for (i = 0, j = 0; i < len && j < patLen; i++) {
            index = s.charAt(i) - 'a';
            j = dfa[index][j];
        }
        if (j == patLen) return i - patLen;
        else return len;
    }

//    public boolean strStartWith(String p, String s, int anchor, int checkPos) {
//        int value;
//        int len = p.length();
//        boolean isDiff = false;
//        for (int i = anchor; i < len; i++) {
//            value = p.charAt(anchor);
//            if(value > 96 && value < 123) {
//                if(value != s.charAt(checkPos)) {
//                    if(isDiff) {
//                        return false;
//                    }
//                    isDiff = true;
//                }
//                anchor++;
//                checkPos++;
//                continue;
//            }
//            if(value == '.') {
//                if(p.charAt(anchor + 1) == '*') {
//
//                }
//            }
//            if(value == '*') {
//                if (isDiff) {
//                    isDiff = false;
//                    anchor++;
//                    checkPos--;
//                    continue;
//                }
//            }
//
//        }
//        if(isDiff) {
//            return false;
//        }
//    }
}
