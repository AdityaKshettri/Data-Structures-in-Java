package com.aditya.project.dp.string;

import java.util.Arrays;

public class MinInsertDeleteReplaceForStringConversion {

    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Min no. of steps to convert string (Recursion) : " + funcRecursion(n, m, a, b));
        System.out.println("Min no. of steps to convert string (Memoization) : " + funcMemoization(n, m, a, b, dp));
        System.out.println("Min no. of steps to convert string (Tabulation) : " + funcTabulation(a, b));
        System.out.println("Min no. of steps to convert string (Space Optimization) : " + funcSpaceOptimization(a, b));
    }

    // Recursion
    // TC : O(3^N)
    // SC : O(N+M)
    private static int funcRecursion(int i, int j, String a, String b) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return funcRecursion(i - 1, j - 1, a, b);
        }
        int insert = 1 + funcRecursion(i, j - 1, a, b);
        int delete = 1 + funcRecursion(i - 1, j, a, b);
        int replace = 1 + funcRecursion(i - 1, j - 1, a, b);
        return Math.min(insert, Math.min(delete, replace));
    }

    // Memoization
    // TC : O(N*M)
    // SC : O(N*M) + O(N+M) for Recursion
    private static int funcMemoization(int i, int j, String a, String b, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = funcMemoization(i - 1, j - 1, a, b, dp);
        }
        int insert = 1 + funcMemoization(i, j - 1, a, b, dp);
        int delete = 1 + funcMemoization(i - 1, j, a, b, dp);
        int replace = 1 + funcMemoization(i - 1, j - 1, a, b, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // Tabulation
    // TC : O(N*M)
    // SC : O(N*M)
    private static int funcTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }

    // Space Optimization
    // TC : O(N*M)
    // SC : O(M)
    private static int funcSpaceOptimization(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] prev = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
