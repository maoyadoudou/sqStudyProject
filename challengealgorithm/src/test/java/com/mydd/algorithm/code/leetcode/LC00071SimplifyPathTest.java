package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00071SimplifyPathTest {

    @Test
    void simplifyPath() {
        assertEquals("/.../home", new LC00071SimplifyPath().simplifyPath("/.../home/"));
        assertEquals("/.../home", new LC00071SimplifyPath().simplifyPath("/.../home/."));
        assertEquals("/...", new LC00071SimplifyPath().simplifyPath("/.../home/.."));
        assertEquals("/c", new LC00071SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/", new LC00071SimplifyPath().simplifyPath("///"));
        assertEquals("/jaxJp", new LC00071SimplifyPath().simplifyPath("/jaxJp/././"));
    }
}