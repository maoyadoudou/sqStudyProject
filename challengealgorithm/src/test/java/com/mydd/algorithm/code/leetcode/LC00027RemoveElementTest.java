package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00027RemoveElementTest {

    @Test
    void removeElement() {
        assertEquals(5, new LC00027RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        assertEquals(2, new LC00027RemoveElement().removeElement(new int[]{3,2,2,3}, 3));
        assertEquals(0, new LC00027RemoveElement().removeElement(new int[]{3}, 3));
    }
}