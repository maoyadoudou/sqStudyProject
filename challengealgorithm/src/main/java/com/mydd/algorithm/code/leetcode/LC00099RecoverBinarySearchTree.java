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
public class LC00099RecoverBinarySearchTree {
    TreeNode prev, suspect1, suspect2;
    public TreeNode recoverTree(TreeNode root) {
        checkAndModify(root);
        int tmp = suspect1.val;
        suspect1.val = suspect2.val;
        suspect2.val = tmp;
        return root;
    }

    private boolean checkAndModify(TreeNode node) {
        if(node == null) return true;
        if(!checkAndModify(node.left)) return false;
        if(prev != null && prev.val > node.val) {
            suspect2 = node;
            if(suspect1 == null) {
                suspect1 = prev;
            } else {
                return false;
            }
        }
        prev = node;
        if(!checkAndModify(node.right)) return false;
        return true;
    }

}
