package com.aditya.project.dp.string;

import static com.aditya.project.dp.string.LongestCommonSubsequence.funcSpaceOptimization;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";
        int n = a.length();
        int m = b.length();
        int longestCommonSubsequence = funcSpaceOptimization(a, b);
        int shortestCommonSuperSequence = n + m - longestCommonSubsequence;
        System.out.println("Shortest Common Super Sequence Length : " + shortestCommonSuperSequence);
    }
}
