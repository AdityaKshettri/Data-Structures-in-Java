package com.aditya.project.dynamic.string;

import java.util.Arrays;

public class LargestRepeatingSubsequence {

    public static void main(String[] args) {
        String a = "aabebcdd";
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Longest Repeating Subsequence Length (Recursion) : " + funcRecursion(n - 1, n - 1, a));
        System.out.println("Longest Repeating Subsequence Length (Memoization) : " + funcMemoization(n - 1, n - 1, a, dp));
        System.out.println("Longest Repeating Subsequence Length (Tabulation) : " + funcTabulation(a));
        System.out.println("Longest Repeating Subsequence Length (Space Optimization) : " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^(N+M))
    // SC : O(N+M)
    private static int funcRecursion(int i, int j, String a) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (a.charAt(i) == a.charAt(j) && i != j) {
            return 1 + funcRecursion(i - 1, j - 1, a);
        }
        return Math.max(funcRecursion(i - 1, j, a), funcRecursion(i, j - 1, a));
    }

    // Memoization
    // TC : O(N*M)
    // SC : O(N*M) + O(N+M) for Recursion
    private static int funcMemoization(int i, int j, String a, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == a.charAt(j) && i != j) {
            return dp[i][j] = 1 + funcMemoization(i - 1, j - 1, a, dp);
        }
        return dp[i][j] = Math.max(funcMemoization(i - 1, j, a, dp), funcMemoization(i, j - 1, a, dp));
    }

    // Tabulation
    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcTabulation(String a) {
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == a.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    // Space Optimization
    // TC : O(N*M)
    // SC : O(M)
    public static int funcSpaceOptimization(String a) {
        int n = a.length();
        int[] prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == a.charAt(j - 1) && i != j) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}
