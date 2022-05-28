package com.aditya.project.dp;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 5;// 0, 1, 1, 2, 3
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("(Recursion) : " + funcRecursion(n));
        System.out.println("(Memoization) : " + funcMemoization(n, dp));
        System.out.println("(Tabulation) : " + funcTabulation(n));
        System.out.println("(Space Optimization) : " + funcSpaceOptimization(n));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return funcRecursion(n - 1) + funcRecursion(n - 2);
    }

    // Memoization
    // TC : O(N)
    // SC : O(N) + O(N) (for Recursion)
    private static int funcMemoization(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = funcMemoization(n - 1, dp) + funcMemoization(n - 2, dp);
    }

    // Tabulation
    // TC : O(N)
    // SC : O(N)
    private static int funcTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Space Optimization
    // TC : O(N)
    // SC : O(1)
    private static int funcSpaceOptimization(int n) {
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
