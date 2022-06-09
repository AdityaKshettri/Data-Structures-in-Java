package com.aditya.project.dynamic.matrix;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Unique Paths : (Recursion) = " + funcRecursion(n - 1, m - 1));
        System.out.println("Unique Paths : (Memoization) = " + funcMemoization(n - 1, m - 1, dp));
        System.out.println("Unique Paths : (Tabulation) = " + funcTabulation(n, m));
        System.out.println("Unique Paths : (Space Optimization) = " + funcSpaceOptimization(n, m));
    }

    // Recursion
    // TC : O(2^(M+N))
    // SC : O(M+N)
    private static int funcRecursion(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        return funcRecursion(row - 1, col) + funcRecursion(row, col - 1);
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(M+N) for recursion
    private static int funcMemoization(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        return dp[row][col] = funcMemoization(row - 1, col, dp) + funcMemoization(row, col - 1, dp);
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static int funcTabulation(int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static int funcSpaceOptimization(int n, int m) {
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
