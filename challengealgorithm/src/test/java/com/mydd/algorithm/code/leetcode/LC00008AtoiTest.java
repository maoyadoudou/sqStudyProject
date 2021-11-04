package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00008AtoiTest {

    @Test
    void atoi() {
        assertEquals(0, new LC00008Atoi().atoi("+-54"));
        assertEquals(-54, new LC00008Atoi().atoi("         -54"));
        assertEquals(54, new LC00008Atoi().atoi("+54"));
        assertEquals(0, new LC00008Atoi().atoi("fffff54"));
        assertEquals(2349, new LC00008Atoi().atoi("  2349snvdso"));
        assertEquals(0, new LC00008Atoi().atoi(" - 54"));
        assertEquals(-54, new LC00008Atoi().atoi("-54"));
        assertEquals(0, new LC00008Atoi().atoi(""));
        assertEquals(0, new LC00008Atoi().atoi("              "));
//        assertEquals(0, new MyAtoi().atoi("+-54"));
//        assertEquals(0, new MyAtoi().atoi("+-54"));


    }
}