package com.aditya.project.dynamic.matrix;

import java.util.Arrays;

public class MinFallingPathSum {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] a = {{3, 2, 1}, {1, 4, 6}, {7, 8, 9}};
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, funcRecursion(n - 1, j, a));
        }
        System.out.println("Min Falling Path Sum in Grid : (Recursion) = " + min);
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, funcMemoization(n - 1, j, a, dp));
        }
        System.out.println("Min Falling Path Sum in Grid : (Memoization) = " + min);
        System.out.println("Min Falling Path Sum in Grid : (Tabulation) = " + funcTabulation(a));
        System.out.println("Min Falling Path Sum in Grid : (Space Optimization) = " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(3^N)
    // SC : O(N)
    private static int funcRecursion(int row, int col, int[][] a) {
        if (col < 0 || col >= a.length) {
            return Integer.MAX_VALUE;
        }
        if (row == 0) {
            return a[0][col];
        }
        int up = funcRecursion(row - 1, col, a);
        int ld = funcRecursion(row - 1, col - 1, a);
        int rd = funcRecursion(row - 1, col + 1, a);
        return a[row][col] + Math.min(up, Math.min(ld, rd));
    }

    // Memoization
    // TC : O(M*N)
    // SC : O(M*N) + O(N) for recursion
    private static int funcMemoization(int row, int col, int[][] a, int[][] dp) {
        if (col < 0 || col >= a.length) {
            return Integer.MAX_VALUE;
        }
        if (row == 0) {
            return a[0][col];
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = funcMemoization(row - 1, col, a, dp);
        int ld = funcMemoization(row - 1, col - 1, a, dp);
        int rd = funcMemoization(row - 1, col + 1, a, dp);
        return dp[row][col] = a[row][col] + Math.min(up, Math.min(ld, rd));
    }

    // Tabulation
    // TC : O(M*N)
    // SC : O(M*N)
    private static int funcTabulation(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = a[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int ld = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    ld = dp[i - 1][j - 1];
                }
                int rd = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    rd = dp[i - 1][j + 1];
                }
                dp[i][j] = a[i][j] + Math.min(up, Math.min(ld, rd));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }

    // Space Optimization
    // TC : O(M*N)
    // SC : O(M)
    private static int funcSpaceOptimization(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[] prev = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = a[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int up = prev[j];
                int ld = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    ld = prev[j - 1];
                }
                int rd = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    rd = prev[j + 1];
                }
                curr[j] = a[i][j] + Math.min(up, Math.min(ld, rd));
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, prev[j]);
        }
        return min;
    }
}
