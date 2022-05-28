package com.aditya.project.dp.string;

import static com.aditya.project.dp.string.LongestCommonSubsequence.funcSpaceOptimization;

public class MinInsertToMakePalindrome {

    public static void main(String[] args) {
        String a = "bbabcbcab";
        String b = new StringBuffer(a).reverse().toString();
        int n = a.length();
        int longestPalindromicSubsequence = funcSpaceOptimization(a, b);
        int minInsert = n - longestPalindromicSubsequence;
        System.out.println("Minimum insert to make string palindrome : " + minInsert);
    }
}
