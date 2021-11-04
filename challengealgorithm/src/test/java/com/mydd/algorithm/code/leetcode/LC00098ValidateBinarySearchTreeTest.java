package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;
import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00098ValidateBinarySearchTreeTest {

    @Test
    void isValidBST() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(15);
        list.add(null);
        list.add(null);
        list.add(-2147483648);
        list.add(20);

        assertEquals(false, new LC00098ValidateBinarySearchTree().isValidBST(UnitTestUtils.gtn(list)));

//        list = new ArrayList<>(Arrays.asList(-2147483648,null,2147483647,-2147483648));
        TreeNode node2 = new TreeNode(-2147483648);
        TreeNode node1 = new TreeNode(2147483647, node2, null);
        TreeNode node = new TreeNode(-2147483648,null, node1);
        assertEquals(false, new LC00098ValidateBinarySearchTree().isValidBST(node));
    }
}