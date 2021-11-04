package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

public class LC00104MaximumDepthofBinaryTree {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    private void dfs (TreeNode node, int height) {
        if (node == null) {
            max = max < height - 1 ? height - 1 : max;
            return;
        }
        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
    }
}
