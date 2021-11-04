package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00103BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    void zigzagLevelOrder() {
        TreeNode node1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode node2 = new TreeNode(3, new TreeNode(9), node1);
        List<List<Integer>> list = new LinkedList();
        List<Integer> list1 = new LinkedList(Arrays.asList(3));
        List<Integer> list2 = new LinkedList(Arrays.asList(20, 9));
        List<Integer> list3 = new LinkedList(Arrays.asList(15, 7));
        list.add(list1);
        list.add(list2);
        list.add(list3);
        assertEquals(list, new LC00103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node2));
    }
}