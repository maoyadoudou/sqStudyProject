package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC00047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<Integer> element = new ArrayList<>(len);
        for(int num : nums) {
            element.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(element);
        int[] clone = nums.clone();
        upPremutaions(nums, res);
        downPremutation(clone, res);
        return res;
    }

    private void upPremutaions(int[] nums, List<List<Integer>> res) {
        int left, right, len = nums.length;
        List<Integer> element;
        for(int i = len - 1; i > 0;) {
            if (nums[i] <= nums[i - 1]) {
                i--;
                continue;
            }
            right = len - 1;
            while (nums[right] <= nums[i - 1]) right--;
            nums[i - 1] = nums[right] + 0 * (nums[right] = nums[i - 1]);
            left = i;
            right = len - 1;
            while (left < right) {
                nums[left] = nums[right] + 0 * (nums[right] = nums[left]);
                left++;
                right--;
            }
            if (left >= right) {
                element = new ArrayList<>(len);
                for(int num : nums) {
                    element.add(num);
                }
                res.add(element);
                i = len - 1;
            } else {
                i--;
            }
        }
    }

    private void downPremutation(int[] nums, List<List<Integer>> res) {
        int left, right, len = nums.length;
        List<Integer> element;
        for(int i = len - 1; i > 0;) {
            if (nums[i] >= nums[i - 1]) {
                i--;
                continue;
            }
            right = len - 1;
            while (nums[right] >= nums[i - 1]) right--;
            nums[i - 1] = nums[right] + 0 * (nums[right] = nums[i - 1]);
            left = i;
            right = len - 1;
            while (left < right) {
                nums[left] = nums[right] + 0 * (nums[right] = nums[left]);
                left++;
                right--;
            }
            if (left >= right) {
                element = new ArrayList<>(len);
                for(int num : nums) {
                    element.add(num);
                }
                res.add(element);
                i = len - 1;
            } else {
                i--;
            }
        }
    }
}
