package com.mydd.algorithm.code.leetcode;

public class LC00009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        if (x < 10) return true;
        int right, quotient;
        int[] record = new int[10];
        for(right = 0; x > 9; right++) {
            quotient = x / 10;
            record[right] = x - quotient * 10;
            x = quotient;

        }
        if (x == record[0]) {
            right -= 1;
            for(int left = 1; left <= right;left++, right--){
                if(record[left] == record[right]) {
                    continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        if (x < 10) return true;
        int rev = 0, quotient = x;
        int[] record = new int[10];
        while (quotient > 0) {
            rev = rev * 10 + quotient % 10;
            quotient /= 10;
        }
        return rev == x;
    }
}
