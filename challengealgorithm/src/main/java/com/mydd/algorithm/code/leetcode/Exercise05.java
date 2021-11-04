package com.mydd.algorithm.code.leetcode;

public class Exercise05 {
    public static void main(String[] args) throws Exception {
        char[] sampleArray = createSampleArray();
        char[] resultArray = replaceBlank(sampleArray);
    }

    public static char[] replaceBlank(char[] originalArray) throws Exception {
        if (originalArray == null || originalArray.length == 0) {
            throw new Exception("Exception: Empty array!");
        }

        int originalLen = originalArray.length;
//        System.out.println("originalLen:" + originalLen);
        int blankNum = 0;
        int notNull = 0;
        for (char c : originalArray) {
            if (c != '\u0000') {
                notNull++;
                if (' ' == c) {
                    blankNum++;
                }
            }
        }
        if (blankNum == 0) {
            return originalArray;
        }

        if (notNull + blankNum * 2 > originalLen) {
            throw new Exception("Exception: Array is too short to replace blank to %20");
        }

        int lastInsertIndex = notNull + blankNum * 2 - 1;
        for(int i = notNull - 1; i > -1; i--) {
            if (' ' != originalArray[i]) {
                originalArray[lastInsertIndex--] = originalArray[i];
            } else {
                originalArray[lastInsertIndex--] = '0';
                originalArray[lastInsertIndex--] = '2';
                originalArray[lastInsertIndex--] = '%';
                if (--blankNum == 0) {
                    break;
                }
            }
        }
//        System.out.println(originalArray);
        return originalArray;
    }

    private static char[] createSampleArray() {
        char[] result = new char[40];
//        String aUrl = "www start to play com";
        String aUrl = "    ";
        for(int i = 0; i < aUrl.length(); i++) {
            result[i] = aUrl.charAt(i);
        }
        System.out.println(result);
        return result;
    }


}
