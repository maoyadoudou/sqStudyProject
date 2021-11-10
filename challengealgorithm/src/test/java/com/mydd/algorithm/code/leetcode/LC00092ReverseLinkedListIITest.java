package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class LC00092ReverseLinkedListIITest {

    @Test
    void reverseBetween() {
        ListNode input = UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7});
        assertEquals(UnitTestUtils.gln(new int[]{7,6,5,4,3,2,1}), new LC00092ReverseLinkedListII().reverseBetween(UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7}), 1, 7));
        assertEquals(UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7}), new LC00092ReverseLinkedListII().reverseBetween(UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7}), 1, 1));
        assertEquals(UnitTestUtils.gln(new int[]{1,4,3,2,5,6,7}), new LC00092ReverseLinkedListII().reverseBetween(UnitTestUtils.gln(new int[]{1,2,3,4,5,6,7}), 2, 4));
    }
}