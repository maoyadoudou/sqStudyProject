package com.mydd.algorithm.code.leetcode;


import com.mydd.model.TreeNode;

public class LC00101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetricTree(left, right);
    }

    private boolean isSymmetricTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) return true;
        if (treeNode1 == null || treeNode2 == null) return false;
        if (!isSymmetricTree(treeNode1.left, treeNode2.right)) return false;
        if (!(treeNode1.val == treeNode2.val)) return false;
        if (!isSymmetricTree(treeNode1.right, treeNode2.left)) return false;
        return true;
    }
}
