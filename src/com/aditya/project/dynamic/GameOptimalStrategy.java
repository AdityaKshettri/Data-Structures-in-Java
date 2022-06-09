package com.aditya.project.dynamic;

import java.util.Arrays;

// Game between User & Opponent to select max values alternatively
// Find the max value that can be collected by User
public class GameOptimalStrategy {

    public static void main(String[] args) {
        int[] a = {20, 30, 2, 2, 2, 10};
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Max value for User (Recursion): " + funcRecursion(0, n - 1, n, a));
        System.out.println("Max value for User (Memoization): " + funcMemoization(0, n - 1, n, a, dp));
        System.out.println("Max value for User (Tabulation): " + funcTabulation(n, a));
    }

    // Recursion
    // TC : O(exp)
    // SC : O(N)
    private static int funcRecursion(int i, int j, int n, int[] a) {
        if (i > j || i >= n || j < 0) {
            return 0;
        }
        int way1 = a[i] + Math.min(funcRecursion(i + 2, j, n, a), funcRecursion(i + 1, j - 1, n, a));
        int way2 = a[j] + Math.min(funcRecursion(i + 1, j - 1, n, a), funcRecursion(i, j - 2, n, a));
        return Math.max(way1, way2);
    }

    // Memoization
    // TC : O(N^2)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int i, int j, int n, int[] a, int[][] dp) {
        if (i > j || i >= n || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int way1 = a[i] + Math.min(funcMemoization(i + 2, j, n, a, dp), funcMemoization(i + 1, j - 1, n, a, dp));
        int way2 = a[j] + Math.min(funcMemoization(i + 1, j - 1, n, a, dp), funcMemoization(i, j - 2, n, a, dp));
        return dp[i][j] = Math.max(way1, way2);
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N^2)
    private static int funcTabulation(int n, int[] a) {
        int[][] dp = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                int x = i + 2 <= j ? dp[i + 2][j] : 0;
                int y = i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0;
                int z = i <= j - 2 ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(a[i] + Math.min(x, y), a[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }
}
