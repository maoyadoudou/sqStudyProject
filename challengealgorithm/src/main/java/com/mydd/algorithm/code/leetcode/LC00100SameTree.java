package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

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
public class LC00100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSame(p, q);
    }

    private boolean checkSame(TreeNode p, TreeNode q) {
        return p == null || q == null ? p == q : (checkSame(p.right, q.right) && p.val == q.val && checkSame(p.left, q.left));
    }
}
