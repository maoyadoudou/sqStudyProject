package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC00095UniqueBinarySearchTreesII {
    // ref:anii_agrawal's code in discuss
    public List<TreeNode> generateTrees(int n) {
        return assembleTree(1, n);
    }


    private List<TreeNode> assembleTree(int lowerLimit, int upperLimit) {
        List<TreeNode> subTrees = new ArrayList<>();
        if(lowerLimit > upperLimit) {
            subTrees.add(null);
            return subTrees;
        }
        for(int i = lowerLimit; i <= upperLimit; i++) {
            List<TreeNode> left = assembleTree(lowerLimit, i - 1);
            List<TreeNode> right = assembleTree(i + 1, upperLimit);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    subTrees.add(new TreeNode(i, l, r));
                }
            }
        }
        return subTrees;
    }
}
