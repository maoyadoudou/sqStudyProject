package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00094BinaryTreeInorderTraversalTest {

    @Test
    void inorderTraversal() {
        List<Integer> input = new ArrayList();
        input.add(1);
        input.add(-1);
        input.add(2);
        input.add(-1);
        input.add(-1);
        input.add(3);
        List<Integer> output = new ArrayList();
        output.add(1);
        output.add(3);
        output.add(2);

        assertEquals(output, new LC00094BinaryTreeInorderTraversal().inorderTraversal(UnitTestUtils.gtn(input)));



        input = new ArrayList();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        output = new ArrayList();
        output.add(4);
        output.add(2);
        output.add(5);
        output.add(1);
        output.add(3);
        assertEquals(output, new LC00094BinaryTreeInorderTraversal().inorderTraversal(UnitTestUtils.gtn(input)));
        input = new ArrayList();
        input.add(1);
        output = new ArrayList();
        output.add(1);
        assertEquals(output, new LC00094BinaryTreeInorderTraversal().inorderTraversal(UnitTestUtils.gtn(input)));
        input = new ArrayList();
        output = new ArrayList();
        assertEquals(output, new LC00094BinaryTreeInorderTraversal().inorderTraversal(UnitTestUtils.gtn(input)));
    }
}