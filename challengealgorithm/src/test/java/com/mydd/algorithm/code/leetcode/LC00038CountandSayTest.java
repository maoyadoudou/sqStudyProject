package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00038CountandSayTest {

    @Test
    void countAndSay() {
        assertEquals("1", new LC00038CountandSay().countAndSay(1));
        assertEquals("1211", new LC00038CountandSay().countAndSay(4));
    }


}