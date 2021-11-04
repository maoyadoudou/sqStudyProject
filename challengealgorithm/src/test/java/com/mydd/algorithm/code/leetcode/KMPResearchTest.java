package com.mydd.algorithm.code.leetcode;

import com.mydd.algorithm.code.topics.KMPResearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPResearchTest {

    @Test
    void KMP() {
        assertEquals("haha", new KMPResearch().KMP("asdfasdfaav"));
    }
}