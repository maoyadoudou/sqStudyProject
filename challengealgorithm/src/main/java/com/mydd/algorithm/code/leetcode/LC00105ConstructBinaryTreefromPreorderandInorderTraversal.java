package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

public class LC00105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int startp, int endp, int[] inorder, int starti, int endi) {
        if(startp > endp) return null;
        TreeNode node = new TreeNode(preorder[startp]);
        int i = starti;
        while (i <= endi && preorder[startp] != inorder[i]) i++;
        node.left = buildTree(preorder, startp + 1, startp + i - starti, inorder, starti, i - 1);
        node.right = buildTree(preorder, startp + i - starti + 1, endp, inorder, i + 1, endi);
        return node;
    }
}
