package com.aditya.project.dynamic.string.lcs;

import static com.aditya.project.dynamic.string.LongestCommonSubsequence.funcSpaceOptimization;

public class MinInsertDeleteForStringConversion {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "anc";
        int n = a.length();
        int m = b.length();
        int longestCommonSubsequence = funcSpaceOptimization(a, b);
        int minInsertDelete = n + m - 2 * longestCommonSubsequence;
        System.out.println("Min Insert/Delete to convert a to b : " + minInsertDelete);
    }
}
