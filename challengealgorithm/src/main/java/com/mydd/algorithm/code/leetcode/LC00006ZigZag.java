package com.mydd.algorithm.code.leetcode;

public class LC00006ZigZag {
    public static void main(String[] args) {
        String a = "PAYPALISHIRING";
        String result = convert(a, 3);
        System.out.println("Finish");
    }
    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) {
            return s;
        }
        Integer a = 0;
        char[] sArray = s.toCharArray();
        char[] result = new char[len];
        if (numRows == 2) {
            boolean isEven = true;
            for(int i = 0; i < len; i++) {
                result[isEven ? (i >> 1) : ((len - i) >> 1) + i] = sArray[i];
                isEven = !isEven;
            }
            return new String(result);
        }
        int unitLen = 2 * (numRows - 1);
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += unitLen) {
                result[index] = sArray[j + i];
                if (i > 0 && i < numRows - 1 && j + unitLen - i < len) {
                    index += 1;
                    result[index] = sArray[j + unitLen - i];
                }
                index += 1;
            }
        }
        return new String(result);
//        List<StringBuilder> list = new ArrayList();
//        for (int i = 0; i < numRows; i++) {
//            list.add(new StringBuilder());
//        }
//        int tempIndex = 0;
//        boolean goDown = false;
//        for (int i = 0; i < len; i++) {
//            list.get(tempIndex).append(sArray[i]);
//            goDown = goDown ^ (tempIndex == 0) ^ (tempIndex == numRows - 1);
//            if (goDown) {
//                tempIndex += 1;
//            } else {
//                tempIndex -= 1;
//            }
//        }
//        StringBuilder resultStr = new StringBuilder();
//        for (int i = 0; i < numRows; i++) {
//            resultStr.append(list.get(i));
//        }
//        return resultStr.toString();
//
//        int numUp = 0;
//        int numDown = 0;
//        while(len >= unitLen) {
//            numUp++;
//            len -= unitLen;
//        }
//        if (len >= numRows) {
//            numUp += 1;
//            numDown = numUp;
//        } else if (len > 0) {
//            numDown = numUp;
//            numUp += 1;
//        } else {
//            numDown = numUp;
//        }
//        len = s.length();
//        int[] resultIndex = initIndex(len, numUp, numDown, numRows);
//        if (numDown == numUp) {
//            resultIndex = rerangeRest1(resultIndex, len, numUp, numDown);
//        } else {
//            resultIndex = rerangeRest2(resultIndex, len, numUp, numDown);
//        }
//
//        char[] result = new char[len];
//        char[] origin = s.toCharArray();
//        for(int i = 0; i < len; i++) {
//            result[i] = origin[resultIndex[i]];
//        }
//        return new String(result);
    }

    private static int[] initIndex(int len, int numUp, int numDown, int row) {
        int[] resultIndex = new int[len];
        int unitLen = 2 * (row - 1);
        while(numDown > 0){
            resultIndex[len - 1] = row - 1 + (numDown - 1) * unitLen;
            len -= 1;
            numDown -= 1;
        }
        while(numUp > 0){
            resultIndex[numUp - 1] = (numUp - 1) * unitLen;
            numUp -= 1;
        }
        return resultIndex;
    }

    private static int[] rerangeRest1(int[] resultIndex, int len, int numUp, int numDown) {
        int anchor = len - numDown - 1;
        int bias = 1;
        for(int i = len - 1; i > len - numDown - 1; i--) {
            int temp = resultIndex[i];
            if (temp + bias < len) {
                resultIndex[anchor] = temp + bias;
                anchor -= 1;
            }
            if (anchor <= numUp - 1) {
                break;
            }
            if (temp - bias > -1) {
                resultIndex[anchor] = temp - bias;
                anchor -= 1;
            }
            if (anchor <= numUp - 1) {
                break;
            }
            if (i == len - numDown) {
                i = len;
                bias += 1;
            }
        }
        return resultIndex;
    }

    private static int[] rerangeRest2(int[] resultIndex, int len, int numUp, int numDown) {
        int anchor = numUp;
        int bias = 1;
        for(int i = 0; i < numUp; i++) {
            int temp = resultIndex[i];
            if (temp - bias > -1) {
                resultIndex[anchor] = temp - bias;
                anchor += 1;
            }
            if (anchor >= len - numDown) {
                break;
            }
            if (temp + bias < len) {
                resultIndex[anchor] = temp + bias;
                anchor += 1;
            }
            if (anchor >= len - numDown) {
                break;
            }

            if (i == numUp - 1) {
                i = -1;
                bias += 1;
            }
        }
        return resultIndex;
    }
}

