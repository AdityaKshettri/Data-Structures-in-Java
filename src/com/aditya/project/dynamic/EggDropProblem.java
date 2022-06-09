package com.aditya.project.dynamic;

import java.util.Arrays;

public class EggDropProblem {

    public static void main(String[] args) {
        int n = 2;
        int k = 10;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Minimum number of trials (Recursion) : " + funcRecursion(n, k));
        System.out.println("Minimum number of trials (Memoization) : " + funcMemoization(n, k, dp));
        System.out.println("Minimum number of trials (Tabulation) : " + funcTabulation(n, k));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int n, int k) {
        if (k == 0 || k == 1) {
            return k;
        }
        if (n == 1) {
            return k;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int res = Math.max(funcRecursion(n - 1, i - 1), funcRecursion(n, k - i));
            min = Math.min(min, res);
        }
        return min + 1;
    }

    // Memoization
    // TC : O(N*K*K)
    // SC : O(N*K) + O(N) for Recursion
    private static int funcMemoization(int n, int k, int[][] dp) {
        if (k == 0 || k == 1) {
            return k;
        }
        if (n == 1) {
            return k;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int res = Math.max(funcMemoization(n - 1, i - 1, dp), funcMemoization(n, k - i, dp));
            min = Math.min(min, res);
        }
        return dp[n][k] = min + 1;
    }

    // Memoization
    // TC : O(N*K*K)
    // SC : O(N*K)
    private static int funcTabulation(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dp[1][i] = k;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    int res = Math.max(funcMemoization(i - 1, p - 1, dp), funcMemoization(i, j - p, dp));
                    min = Math.min(min, res);
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }
}
