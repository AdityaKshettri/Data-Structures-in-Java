package com.aditya.project.dynamic.matrix;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Min Path Sum in Grid : (Recursion) = " + funcRecursion(n - 1, m - 1, a));
        System.out.println("Min Path Sum in Grid : (Memoization) = " + funcMemoization(n - 1, m - 1, a, dp));
        System.out.println("Min Path Sum in Grid : (Tabulation) = " + funcTabulation(n, m, a));
        System.out.println("Min Path Sum in Grid : (Space Optimization) = " + funcSpaceOptimization(n, m, a));
    }

    // Recursion
    // TC : O(2^(M+N))
    // SC : O(M+N)
    private static int funcRecursion(int row, int col, int[][] a) {
        if (row == 0 && col == 0) {
            return a[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        return a[row][col] + Math.min(funcRecursion(row - 1, col, a), funcRecursion(row, col - 1, a));
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(M+N) for recursion
    private static int funcMemoization(int row, int col, int[][] a, int[][] dp) {
        if (row == 0 && col == 0) {
            return a[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        return dp[row][col] = a[row][col] + Math.min(funcMemoization(row - 1, col, a, dp), funcMemoization(row, col - 1, a, dp));
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static int funcTabulation(int n, int m, int[][] a) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = a[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = a[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static int funcSpaceOptimization(int n, int m, int[][] a) {
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = a[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = a[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
