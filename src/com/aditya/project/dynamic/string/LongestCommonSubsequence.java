package com.aditya.project.dynamic.string;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "adebc";
        String b = "dcadb";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Longest Common Subsequence Length (Recursion) : " + funcRecursion(n - 1, m - 1, a, b));
        System.out.println("Longest Common Subsequence Length (Memoization) : " + funcMemoization(n - 1, m - 1, a, b, dp));
        System.out.println("Longest Common Subsequence Length (Tabulation) : " + funcTabulation(a, b));
        System.out.println("Longest Common Subsequence Length (Space Optimization) : " + funcSpaceOptimization(a, b));
    }

    // Recursion
    // TC : O(2^(N+M))
    // SC : O(N+M)
    private static int funcRecursion(int i, int j, String a, String b) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return 1 + funcRecursion(i - 1, j - 1, a, b);
        }
        return Math.max(funcRecursion(i - 1, j, a, b), funcRecursion(i, j - 1, a, b));
    }

    // Memoization
    // TC : O(N*M)
    // SC : O(N*M) + O(N+M) for Recursion
    private static int funcMemoization(int i, int j, String a, String b, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + funcMemoization(i - 1, j - 1, a, b, dp);
        }
        return dp[i][j] = Math.max(funcMemoization(i - 1, j, a, b, dp), funcMemoization(i, j - 1, a, b, dp));
    }

    // Tabulation
    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // Space Optimization
    // TC : O(N*M)
    // SC : O(M)
    public static int funcSpaceOptimization(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
