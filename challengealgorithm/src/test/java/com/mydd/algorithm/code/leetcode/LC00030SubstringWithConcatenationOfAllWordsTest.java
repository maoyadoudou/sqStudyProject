package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00030SubstringWithConcatenationOfAllWordsTest {

    @Test
    void findSubstringIndex() {
        assertEquals(new ArrayList(Arrays.asList(0, 9)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("barfoothefoobarman", new String[]{"foo","bar"}));
        assertEquals(new ArrayList(), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        assertEquals(new ArrayList(Arrays.asList(6, 9, 12)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        assertEquals(new ArrayList(Arrays.asList(8)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        assertEquals(new ArrayList(Arrays.asList(0, 3, 6)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("foobarfoobar", new String[]{"foo","bar"}));
        assertEquals(new ArrayList(Arrays.asList(0, 2, 4, 6, 8, 10, 1, 3, 5, 7, 9)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("aaaaaaaaaaaaaa", new String[]{"aa","aa"}));
        assertEquals(new ArrayList(Arrays.asList(6,16,17,18,19,20)), new LC00030SubstringWithConcatenationOfAllWords().findSubstringIndex("bcabbcaabbccacacbabccacaababcbb", new String[]{"c","b","a","c","a","a","a","b","c"}));
    }
}