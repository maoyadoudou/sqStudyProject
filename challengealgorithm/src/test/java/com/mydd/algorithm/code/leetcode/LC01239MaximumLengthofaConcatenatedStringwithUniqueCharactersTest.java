package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC01239MaximumLengthofaConcatenatedStringwithUniqueCharactersTest {

    @Test
    void maxLength() {
        List<String> s = new ArrayList();
        s.add("cha");
        s.add("r");
        s.add("act");
        s.add("ers");
        assertEquals(6, new LC01239MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(s));
        s = new ArrayList();
        s.add("a");
        s.add("r");
        s.add("act");
        s.add("abcdefghijklmnopqrstuvwxyz");
        assertEquals(26, new LC01239MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(s));
        s = new ArrayList();
        s.add("aa");
        s.add("r");
        s.add("act");
        s.add("abcdefghijklmnopqrstuvwxyz");
        assertEquals(26, new LC01239MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(s));
    }
}