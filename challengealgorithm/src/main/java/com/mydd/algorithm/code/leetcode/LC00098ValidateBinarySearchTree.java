package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

public class LC00098ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) return true;
        if (root.left != null  && (root.left.val >= root.val || (lowerLimit != null && root.left.val  <= lowerLimit))) {
            return false;
        }
        if (root.right != null && (root.right.val <= root.val || (upperLimit != null && root.right.val >= upperLimit))) {
            return false;
        }
        return isValid(root.left,  lowerLimit, root.val) && isValid(root.right, root.val, upperLimit);
    }

}
