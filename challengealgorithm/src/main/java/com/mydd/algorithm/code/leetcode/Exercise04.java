package com.mydd.algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Exercise04 {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        getCompareResult();
    }

    public static void getCompareResult() {
        int length = getRandomInt(10) + 1;
        int[][] sample = getSampleMatrix(length);
        int random = createRandomIntInRange(sample[0][0], sample[length - 1][length - 1]);
        filterResult(sample, length, random);
        StringBuilder a = new StringBuilder("Hello World!");
    }

    private static int[][] getSampleMatrix(int length) {
        int[][] sample = new int[length][length];
        int current = 0;
        sample[0][0] = getRandomInt(10);
        for (int i = 1; i < length; i++) {
            sample[i][current] = sample[i - 1][current] + getRandomInt(10);
            sample[current][i] = sample[current][i - 1] + getRandomInt(10);
        }
        if (current + 1 < length) {
            sample = createBigGammaSideData(current, length, sample);
        }
        System.out.println("Create Matrix is:");
        Arrays.stream(sample).forEach(e -> {
            Arrays.stream(e).forEach(subE -> System.out.format("%5d", subE));
            System.out.println();
        });
        return sample;
    }

    private static int[][] createBigGammaSideData(int previous, int length, int[][] sample) {
        int current = previous + 1;
        sample[current][current] = getBiggerElementData(sample, current, current);
        if (current + 1 == length) {
            return sample;
        }
        for (int i = current + 1; i < length; i++) {
            sample[i][current] = getBiggerElementData(sample, i, current);
            sample[current][i] = getBiggerElementData(sample, current, i);
        }
        return createBigGammaSideData(current, length, sample);
    }

    private static int getBiggerElementData(int[][] sample, int row, int column) {
        return Math.max(sample[row][column - 1], sample[row - 1][column]) + getRandomInt(10);
    }

    private static int getRandomInt(int scale) {
        return RANDOM.nextInt(scale);
    }

    private static int createRandomIntInRange(int min, int max) {
        if (max < 1) {
            return 0;
        }
        int result = min - 1;
        while (result < min) {
            result = RANDOM.nextInt(max) + 1;
        }
        System.out.println("Random filter number is : " + result);
        return result;
    }

    public static boolean filterResult(int[][] sample, int length, int target) {
        try {
            length = length < 1 ? sample.length : length;
            for (int row = 0, column = length - 1; row < length && column > -1; ) {
                if (sample[row][column] < target) {
                    row++;
                    continue;
                }
                if (sample[row][column] > target) {
                    column--;
                    continue;
                }
                outputResult(sample, length, row, column);
                return true;
            }
            System.out.println("Sorry! No matched number is equal to " + target);
            return false;
        } catch (NullPointerException e) {
            throw new NullPointerException("sample is NULL！Please Check！");
        }

    }

    private static void outputResult(int[][] sample, int length, int row, int column) {
        if (0 == length) {
            length = sample.length;
        }

        int addSide = length + 1;
        System.out.format("%5s", "");
        for (int i = 1; i < addSide; i++) {
            System.out.format("%5s", " " + i + " ");
        }
        System.out.println();
        boolean targetRow;
        for (int i = 0; i < length; i++) {
            System.out.format("%5s", " " + (i + 1) + " ");
            targetRow = i == row;
            for (int j = 0; j < length; j++) {
                if (targetRow && column == j) {
                    System.out.format("%5s", "{" + sample[i][j] + "}");
                } else {
                    System.out.format("%5s", " " + sample[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Get one matched number in row " + (row + 1) + " and column " + (column + 1) + " is equal to " + sample[row][column]);
    }

}
