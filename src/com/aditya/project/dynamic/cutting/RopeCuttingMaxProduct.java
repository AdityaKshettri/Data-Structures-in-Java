package com.aditya.project.dynamic.cutting;

import java.util.Arrays;

public class RopeCuttingMaxProduct {

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Max Product while cutting rope (Recursion) : " + funcRecursion(n));
        System.out.println("Max Product while cutting rope (Memoization) : " + funcMemoization(n, dp));
        System.out.println("Max Product while cutting rope (Tabulation) : " + funcTabulation(n));
    }

    // Recursion
    // TC : O(exp)
    // SC : O(N)
    private static int funcRecursion(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int product = 0;
        for (int i = 1; i < n; i++) {
            product = Math.max(product, Math.max(i * (n - i), funcRecursion(n - i) * i));
        }
        return product;
    }

    // Memoization
    // TC : O(N^2)
    // SC : O(N) + O(N) for Recursion
    private static int funcMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int product = 0;
        for (int i = 1; i < n; i++) {
            product = Math.max(product, Math.max(i * (n - i), funcMemoization(n - i, dp) * i));
        }
        return dp[n] = product;
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N)
    private static int funcTabulation(int n) {
        int[] dp = new int[n + 1];
        for (int j = 2; j <= n; j++) {
            int product = 0;
            for (int i = 1; i < j; i++) {
                product = Math.max(product, Math.max(i * (j - i), dp[j - i] * i));
            }
            dp[j] = product;
        }
        return dp[n];
    }
}
