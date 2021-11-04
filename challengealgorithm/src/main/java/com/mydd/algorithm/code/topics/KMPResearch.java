package com.mydd.algorithm.code.topics;

import java.util.Arrays;

public class KMPResearch{
    private int[][] dfa;
    private String pat;
    public String KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
//        output(dfa);
        for(int x = 0, j = 1; j < M; j++) {
            for(int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            output(dfa);
            dfa[pat.charAt(j)][j] = j + 1;
            output(dfa);
            x = dfa[pat.charAt(j)][x];
            printDivideLine();
        }
        return "haha";
    }
    public int search(String text) {
        int tlen = text.length(), plen = pat.length();
        int i = 0, j = 0;
        for(; i < tlen && j < plen; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == plen) return i - plen;
        else return tlen;
    }
    private void output(int[][] dfa) {
        for(int i = 97; i < 123; i++) {
            System.out.println(Arrays.toString(dfa[i]));
        }
        printDivideLine();
    }

    private void printDivideLine() {
        System.out.println("============================================================================");
    }

    public void generateDFA(String pat) {
        this.pat = pat;
        int R = 256;
        int n = pat.length();
        int[][] dfa = new int[R][n];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < n; j++) {
            for(int i = 0; i < R; i++){
                dfa[i][j] = dfa[i][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }
}
