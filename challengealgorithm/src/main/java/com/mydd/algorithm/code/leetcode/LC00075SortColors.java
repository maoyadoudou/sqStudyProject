package com.mydd.algorithm.code.leetcode;

public class LC00075SortColors {
    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = 0, j = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }


    public static void sortColors1(int[] nums) {
        int len = nums.length;
        if (len == 1) return;
        for (int i = 0, end = len, midLeft = 0, midRight = 0; midRight < end;) {
            if (nums[i] == 0) {
                midLeft++;
                midRight++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end - 1);
                end--;
            } else {
                while(nums[midRight] == 1) midRight++;
                if (midRight < end) swap(nums, midLeft, midRight);
            }
        }
        return;
    }
    private static void swap(int[] swap, int i, int j) {
        int tmp = swap[i];
        swap[i] = swap[j];
        swap[j] = tmp;
    }

    public static void main(String[] args) {
//        sortColors(new int[]{2,0,2,1,1,0});
//        sortColors(new int[]{2,1});
//        sortColors(new int[]{1,2});
        sortColors(new int[]{1,2,0});
    }
}
