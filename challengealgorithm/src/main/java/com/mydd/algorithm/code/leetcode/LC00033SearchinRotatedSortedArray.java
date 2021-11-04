package com.mydd.algorithm.code.leetcode;

public class LC00033SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length, mid = len >> 1;
        if (nums[mid] == target) return mid;
        if (nums[0] == target) return 0;
        if (nums[len - 1] == target) return len - 1;
        boolean isRight = nums[mid] > nums[len - 1];
        if (isRight) {
            if (target < nums[0] || target > nums[mid]) return binarySearch(mid + 1, len - 1, target, nums);
            else return binarySearch(target, nums, 1, mid - 1);
        } else {
            if (target > nums[len - 1] || target < nums[mid]) return binarySearch(1, mid, target, nums);
            else return binarySearch(target, nums, mid + 1, len - 2);
        }
    }

    private int binarySearch(int target, int[] nums, int start, int end) {
        if(end < 0) return -1;
        int mid = (start + end) >> 1;
        while(start <= end) {
            if(target > nums[mid]) {
                start = mid + 1;
                mid = (start + end) >> 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
                mid = (end + start) >> 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int binarySearch(int start, int end, int target, int[] nums) {
        if(end < 0) return -1;
        int mid = (start + end) >> 1;
        if(target < nums[end]) {
            while(start <= end) {
                if(target > nums[mid]) {
                    return binarySearch(target, nums, mid + 1, end);
                } else if (target < nums[mid]) {
                    if (nums[mid] < nums[end]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    mid = (end + start) >> 1;
                } else {
                    return mid;
                }
            }
        } else {
            while(start <= end) {
                if(target > nums[mid]) {
                    if (nums[mid] > nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                    mid = (start + end) >> 1;
                } else if (target < nums[mid]) {
                    return binarySearch(target, nums, start, mid - 1);
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
