package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise05Test {
    private static final int ARRAY_LEN = 40;
    private char[] sample;

    @BeforeEach
    void setUp() {
        sample = createSampleArray();
    }

    @Test
    void replaceBlank() throws Exception {
        testHaveBlankBetweenWords();
        testHaveBlankBeforeWords();
        testHaveBlankAfterWords();
        testOnlyHaveBlank();
        testSampleIsNull();
        testSampleIsEmpty();
    }

    private void testSampleIsEmpty() {
        Exception e = Assertions.assertThrows(Exception.class, () -> Exercise05.replaceBlank(new char[0]));
        Assertions.assertEquals("Exception: Empty array!", e.getMessage());
    }

    private void testSampleIsNull() {
        Exception e = Assertions.assertThrows(Exception.class, () -> Exercise05.replaceBlank(null));
        Assertions.assertEquals("Exception: Empty array!", e.getMessage());
    }

    private void testOnlyHaveBlank() throws Exception {
        char[] sample = createSampleArray(" ");
        Assertions.assertArrayEquals(createSampleArray("%20"), Exercise05.replaceBlank(sample));
    }

    private void testHaveBlankAfterWords() throws Exception {
        char[] sample = createSampleArray("www start to play com   ");
        Assertions.assertArrayEquals(createSampleArray("www%20start%20to%20play%20com%20%20%20"), Exercise05.replaceBlank(sample));
    }

    private void testHaveBlankBeforeWords() throws Exception {
        char[] sample = createSampleArray("   www start to play com");
        Assertions.assertArrayEquals(createSampleArray("%20%20%20www%20start%20to%20play%20com"), Exercise05.replaceBlank(sample));
    }

    private void testHaveBlankBetweenWords() throws Exception {
        char[] sample = createSampleArray();
        Assertions.assertArrayEquals(createSampleArray("www%20start%20to%20play%20com"), Exercise05.replaceBlank(sample));
    }

    private static char[] createSampleArray() {
        String aUrl = "www start to play com";
        return createSampleArray(aUrl);
    }
    
    private static char[] createSampleArray(String str) {
        char[] result = new char[ARRAY_LEN];
        int len = str.length();
        if (len == 0) {
            return result;
        }
        for(int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
//        System.out.println(result);
        return result;
    }
}