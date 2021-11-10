package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC00094RestoreIPAddressesTest {
    @Test
    void restoreIpAddresses() {
        List<String> result = new ArrayList<>();
        result.add("255.255.11.135");
        result.add("255.255.111.35");
        assertEquals(result, new LC00094RestoreIPAddresses().restoreIpAddresses("25525511135"));
        result = new ArrayList<>();
        result.add("0.0.0.0");
        assertEquals(result, new LC00094RestoreIPAddresses().restoreIpAddresses("0000"));
        result = new ArrayList<>();
        result.add("0.10.0.10");
        result.add("0.100.1.0");
        assertEquals(result, new LC00094RestoreIPAddresses().restoreIpAddresses("010010"));
    }
}