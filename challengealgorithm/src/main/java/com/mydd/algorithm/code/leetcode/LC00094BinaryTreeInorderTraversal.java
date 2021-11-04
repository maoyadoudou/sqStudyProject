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
public class LC00094BinaryTreeInorderTraversal {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode tree) {
        if (tree == null) return;
        inOrder(tree.left);
        res.add(tree.val);
        inOrder(tree.right);
    }
}
