package com.mydd.algorithm.code.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Exercise04Test {

    private static final int[][] matrix = {
            {9, 18,18,20,20,24, 26, 31, 34, 38},
            {9, 25,31,36,41,49, 49, 51, 57, 57},
            {11,26,38,45,54,56, 62, 66, 73, 77},
            {17,35,46,46,60,66, 70, 70, 74, 86},
            {26,38,53,58,69,73, 82, 82, 88, 92},
            {33,39,55,63,76,83, 88, 96, 102,111},
            {38,39,55,65,76,90, 95, 100,104,111},
            {43,44,61,65,76,97, 102,102,113,119},
            {51,53,62,74,81,98, 110,112,118,123},
            {57,60,62,76,84,106,114,117,127,132}};

    @BeforeAll
    public static void setUp() {
        System.out.println("start");
    }

    @Test
    public void sampleMatrixTest() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    // 查找的数在数组里面
    private void test1() {
        Assertions.assertTrue(Exercise04.filterResult(matrix, 0, 117));
    }

    // 查找的数在数组最大最小范围内，但不在数组里面
    private void test2() {
        Assertions.assertFalse(Exercise04.filterResult(matrix, 0, 59));
    }

    // 查找的数在数组最小值
    private void test3() {
        Assertions.assertTrue(Exercise04.filterResult(matrix, 0, 9));
    }

    // 查找的数在数组最大值
    private void test4() {
        Assertions.assertTrue(Exercise04.filterResult(matrix, 0, 132));
    }

    // 查找的数比数组最小值还小
    private void test5() {
        Assertions.assertFalse(Exercise04.filterResult(matrix, 0, 7));
    }

    // 查找的数比数组最大值还大
    private void test6() {
        Assertions.assertFalse(Exercise04.filterResult(matrix, 0, 150));
    }

    // 数组为空
    private void test7() {
        Exception e = Assertions.assertThrows(NullPointerException.class, () -> Exercise04.filterResult(null, 0, 150));
        Assertions.assertEquals("sample is NULL！Please Check！", e.getMessage());
    }

    @Test
    void filterResult() {
    }
}