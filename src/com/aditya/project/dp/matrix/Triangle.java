package com.aditya.project.dp.matrix;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        int[][] a = {{1}, {2, 3}, {3, 6, 7}, {8, 9, 6, 10}};
        int n = a.length;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Min Triangle Path Sum : (Recursion) = " + funcRecursion(0, 0, n, a));
        System.out.println("Min Triangle Path Sum : (Memoization) = " + funcMemoization(0, 0, n, a, dp));
        System.out.println("Min Triangle Path Sum : (Tabulation) = " + funcTabulation(a));
        System.out.println("Min Triangle Path Sum : (Space Optimization) = " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int row, int col, int n, int[][] a) {
        if (row == n - 1) {
            return a[n - 1][col];
        }
        int down = funcRecursion(row + 1, col, n, a);
        int rd = funcRecursion(row + 1, col + 1, n, a);
        return a[row][col] + Math.min(down, rd);
    }

    // Memoization
    // TC : O(N*N)
    // SC : O(N*N) + O(N) for recursion
    private static int funcMemoization(int row, int col, int n, int[][] a, int[][] dp) {
        if (row == n - 1) {
            return a[n - 1][col];
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int down = funcMemoization(row + 1, col, n, a, dp);
        int rd = funcMemoization(row + 1, col + 1, n, a, dp);
        return dp[row][col] = a[row][col] + Math.min(down, rd);
    }

    // Tabulation
    // TC : O(N*N)
    // SC : O(N*N)
    private static int funcTabulation(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
        }
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = a[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[i + 1][j];
                int rd = dp[i + 1][j + 1];
                dp[i][j] = a[i][j] + Math.min(down, rd);
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    // TC : O(N*N)
    // SC : O(N)
    private static int funcSpaceOptimization(int[][] a) {
        int n = a.length;
        int[] next = new int[n];
        for (int j = 0; j < n; j++) {
            next[j] = a[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j <= i; j++) {
                int down = next[j];
                int rd = next[j + 1];
                curr[j] = a[i][j] + Math.min(down, rd);
            }
            next = curr;
        }
        return next[0];
    }
}
