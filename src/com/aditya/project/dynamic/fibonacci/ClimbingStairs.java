package com.aditya.project.dynamic.fibonacci;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Total no. of ways taking 1 or 2 steps to reach n (Recursion) : " + funcRecursion(n));
        System.out.println("Total no. of ways taking 1 or 2 steps to reach n (Memoization) : " + funcMemoization(n, dp));
        System.out.println("Total no. of ways taking 1 or 2 steps to reach n (Tabulation) : " + funcTabulation(n));
        System.out.println("Total no. of ways taking 1 or 2 steps to reach n (Space Optimization) : " + funcSpaceOptimization(n));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int n) {
        if (n <= 1) {
            return 1;
        }
        return funcRecursion(n - 1) + funcRecursion(n - 2);
    }

    // Memoization
    // TC : O(N)
    // SC : O(N) + O(N) (for Recursion)
    private static int funcMemoization(int n, int[] dp) {
        if (n <= 1) {
            return 1;
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
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
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
        if (n <= 2) {
            return n;
        }
        int prev2 = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
