package com.aditya.project.dynamic.string.lcs;

import static com.aditya.project.dynamic.string.LongestCommonSubsequence.funcSpaceOptimization;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String a = "bbabcbcab";
        String b = new StringBuffer(a).reverse().toString();
        int longestCommonSubsequence = funcSpaceOptimization(a, b);
        System.out.println("Longest Palindromic Subsequence Length : " + longestCommonSubsequence);
    }
}
