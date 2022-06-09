package com.aditya.project.dynamic.partition;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.printf("Matrix Chain Multiplication (Recursion) : %d\n", funcRecursion(1, n - 1, a));
        System.out.printf("Matrix Chain Multiplication (Memoization) : %d\n", funcMemoization(1, n - 1, a, dp));
        System.out.printf("Matrix Chain Multiplication (Tabulation) : %d\n", funcTabulation(a));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int i, int j, int[] a) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = a[i - 1] * a[k] * a[j] + funcRecursion(i, k, a) + funcRecursion(k + 1, j, a);
            min = Math.min(min, steps);
        }
        return min;
    }

    // Memoization
    // TC : O(N^3)
    // SC : O(N^2) + O(N) for recursion
    private static int funcMemoization(int i, int j, int[] a, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = a[i - 1] * a[k] * a[j] + funcMemoization(i, k, a, dp) + funcMemoization(k + 1, j, a, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }

    // Tabulation
    // TC : O(N^3)
    // SC : O(N^2)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = a[i - 1] * a[k] * a[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }
}
