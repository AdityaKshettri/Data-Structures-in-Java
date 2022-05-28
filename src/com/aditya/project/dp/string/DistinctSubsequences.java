package com.aditya.project.dp.string;

import java.util.Arrays;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String a = "bagbag";
        String b = "bag";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Distinct Subsequences (Recursion) : " + funcRecursion(n - 1, m - 1, a, b));
        System.out.println("Distinct Subsequences (Memoization) : " + funcMemoization(n - 1, m - 1, a, b, dp));
        System.out.println("Distinct Subsequences (Tabulation) : " + funcTabulation(a, b));
        System.out.println("Distinct Subsequences (Space Optimization) : " + funcSpaceOptimization(a, b));
    }

    // Recursion
    // TC : O(2^(M+N))
    // SC : O(M+N)
    private static int funcRecursion(int i, int j, String a, String b) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return funcRecursion(i - 1, j - 1, a, b) + funcRecursion(i - 1, j, a, b);
        } else {
            return funcRecursion(i - 1, j, a, b);
        }
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(M+N) for Recursion
    private static int funcMemoization(int i, int j, String a, String b, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = funcMemoization(i - 1, j - 1, a, b, dp) + funcMemoization(i - 1, j, a, b, dp);
        } else {
            return dp[i][j] = funcMemoization(i - 1, j, a, b, dp);
        }
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static int funcTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static int funcSpaceOptimization(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
