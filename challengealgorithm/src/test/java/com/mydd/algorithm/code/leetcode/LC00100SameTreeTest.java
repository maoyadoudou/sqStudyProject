package com.mydd.algorithm.code.leetcode;

import com.mydd.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00100SameTreeTest {

    @Test
    void isSameTree() {
        TreeNode nodeW = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode nodeW1 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode nodeR = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        assertEquals(true, new LC00100SameTree().isSameTree(null, null));
    }
}