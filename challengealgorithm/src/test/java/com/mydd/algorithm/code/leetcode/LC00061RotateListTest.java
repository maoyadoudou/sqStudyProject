package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC00061RotateListTest {

    @Test
    void rotateRight() {
        ListNode InputNode = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
        ListNode OutputNode = UnitTestUtils.gln(new int[]{5,6,7,1,2,3,4});
        assertEquals(OutputNode, new LC00061RotateList().rotateRight(InputNode, 3));

        InputNode = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
        OutputNode = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
        assertEquals(OutputNode, new LC00061RotateList().rotateRight(InputNode, 7));

        InputNode = null;
        OutputNode = null;
        assertEquals(OutputNode, new LC00061RotateList().rotateRight(InputNode, 7));
        // make sure test can find error, when error exists
//        InputNode = null;
//        OutputNode = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
//        assertEquals(OutputNode, new LC00061RotateList().rotateRight(InputNode, 7));
//        InputNode = UnitTestUtils.gln(new int[]{5,6,7,1,2,3,4});
//        OutputNode = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
//        assertEquals(OutputNode, new LC00061RotateList().rotateRight(InputNode, 7));
    }
}