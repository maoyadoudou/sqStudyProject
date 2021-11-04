package com.mydd.algorithm.code.leetcode;

import java.util.Arrays;

public class LC00016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) return nums[0] + nums[1] + nums[2];
        int triSection = target / 3, eqTriIndex;
        Arrays.parallelSort(nums);
        if (nums[len - 1] <= triSection) {
            return nums[len - 1] + nums[len - 2] + nums[len - 3];
        }
        if (nums[0] >= triSection) {
            return nums[0] + nums[1] + nums[2];
        }
        eqTriIndex = Arrays.binarySearch(nums, triSection - 1);
        eqTriIndex = eqTriIndex < 0 ? -(eqTriIndex + 1) : eqTriIndex;
        if (3 * triSection == target) {
            int i = eqTriIndex, num = 0;
            while(num < 4 && i < len && nums[i] == triSection) {
                i++;
                num++;
                if(nums[i] > triSection) {
                    break;
                }
            }
            if (num == 3) return target;
        }
        int tmp = eqTriIndex, delta, delta2, l, r, min = Integer.MAX_VALUE, min2 = min;
        while(nums[tmp++] <= triSection) eqTriIndex++;
        for(int i = 0; i < eqTriIndex; i++) {
            tmp = nums[i];
            l = i + 1;
            r = len - 1;
            while(r > l) {
                delta = target - (tmp + nums[l] + nums[r]);
                if(delta == 0) {
                    return target;
                } else {
                    delta2 = delta * delta;
                    if(min2 > delta2) {
                        min = delta;
                        min2 = delta2;
                    }
                    if(delta < 0) {
                        while(r > eqTriIndex - 1 && nums[r - 1] == nums[r]) r--;
                        r--;
                    } else {
                        while(eqTriIndex > l && nums[l + 1] == nums[l]) l++;
                        l++;
                    }
                }
            }
        }
        return target - min;
    }
}
