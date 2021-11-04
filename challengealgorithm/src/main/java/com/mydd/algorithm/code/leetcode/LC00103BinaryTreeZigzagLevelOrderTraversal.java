package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC00103BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        assemble(root, 0, true);
        return res;
    }

    private void assemble(TreeNode node, int level, boolean headR) {
        if(node == null) return;
        LinkedList<Integer> list;
        if(res.size() > level) {
            list = (LinkedList) res.get(level);
        } else {
            list = new LinkedList<>();
            res.add(list);
        }
        if(headR) {
            list.addLast(node.val);
        } else {
            list.addFirst(node.val);
        }
        assemble(node.left, level + 1, !headR);
        assemble(node.right, level + 1, !headR);
    }
}
