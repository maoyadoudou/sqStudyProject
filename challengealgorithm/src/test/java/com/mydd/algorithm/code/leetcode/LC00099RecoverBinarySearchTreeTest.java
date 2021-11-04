package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00099RecoverBinarySearchTreeTest {

    @Test
    void recoverTree() {
        TreeNode nodeW = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode nodeW1 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode nodeR = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        assertEquals(nodeW1, new LC00099RecoverBinarySearchTree().recoverTree(nodeW));
    }
}