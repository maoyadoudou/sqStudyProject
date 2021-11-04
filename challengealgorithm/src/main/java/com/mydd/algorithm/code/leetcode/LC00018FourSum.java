package com.mydd.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return multiSum(nums, target, 0, 4);
    }

    private List<List<Integer>> multiSum(int[] nums, int target, int start, int k){
        List<List<Integer>> res = new ArrayList();
        int len = nums.length, max = nums[len - 1];
        if (target > k * nums[len - 1] || target < k * nums[start]) return res;
        if (k == 2) {
            return twoSum(nums, target, start, res);
        }
        len -= (k - 1);
        for(int i = start; i < len; i++) {
            if(nums[i] + (k - 1) * max < target) {
                continue;
            }
            for(List<Integer> item : multiSum(nums, target - nums[i], i + 1, k - 1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(item);
            }
            while(i < len && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start, List<List<Integer>> res) {
        int index;
        for(int i = start; i < nums.length - 1; i++) {
            index = Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]);
            if(index > -1 && index > i) {
                res.add(Arrays.asList(nums[i], nums[index]));
            }
            while(i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
