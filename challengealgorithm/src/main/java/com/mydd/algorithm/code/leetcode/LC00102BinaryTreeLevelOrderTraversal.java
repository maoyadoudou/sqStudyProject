package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC00102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        do {
            List<Integer> numList = new ArrayList();
            int size = queue.size();
            do {
                TreeNode tmpNode = queue.remove();
                numList.add(tmpNode.val);
                if (tmpNode.left != null) queue.add(tmpNode.left);
                if (tmpNode.right != null) queue.add(tmpNode.right);
            } while (--size > 0);
            result.add(numList);
        } while (!queue.isEmpty());
        return result;
    }
}
