package com.aditya.project.dynamic.stocks;

import java.util.Arrays;

// Find min time to skip the work
// 2 consecutive cannot be skipped
public class SkipTheWork {

    public static void main(String[] args) {
        int[] a = {10, 5, 2, 4, 8, 6, 7, 10};
        int n = a.length;
        int[][] dp = new int[n][2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Min time to Skip the Work (Recursion) : " + funcRecursion(n - 1, 1, a));
        System.out.println("Min time to Skip the Work (Memoization) : " + funcMemoization(n - 1, 1, a, dp));
        System.out.println("Min time to Skip the Work (Tabulation) : " + funcTabulation(a));
        System.out.println("Min time to Skip the Work (Space Optimization) : " + funcSpaceOptimization(a));
        System.out.println("Min time to Skip the Work (Variable Solution) : " + funcVariableSolution(a));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int index, int skip, int[] a) {
        if (index < 0) {
            return 0;
        }
        int notTake = Integer.MAX_VALUE;
        if (skip == 1) {
            notTake = funcRecursion(index - 1, 0, a);
        }
        int take = a[index] + funcRecursion(index - 1, 1, a);
        return Math.min(take, notTake);
    }

    // Memoization
    // TC : O(N*2)
    // SC : O(N*2) + O(N) for Recursion
    private static int funcMemoization(int index, int skip, int[] a, int[][] dp) {
        if (index < 0) {
            return 0;
        }
        if (dp[index][skip] != -1) {
            return dp[index][skip];
        }
        int notTake = Integer.MAX_VALUE;
        if (skip == 1) {
            notTake = funcMemoization(index - 1, 0, a, dp);
        }
        int take = a[index] + funcMemoization(index - 1, 1, a, dp);
        return dp[index][skip] = Math.min(take, notTake);
    }

    // Tabulation
    // TC : O(N*2)
    // SC : O(N*2)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][2];
        for (int index = 1; index <= n; index++) {
            for (int skip = 0; skip < 2; skip++) {
                int notTake = Integer.MAX_VALUE;
                if (skip == 1) {
                    notTake = dp[index - 1][0];
                }
                int take = a[index - 1] + dp[index - 1][1];
                dp[index][skip] = Math.min(take, notTake);
            }
        }
        return dp[n][1];
    }

    // Space Optimization
    // TC : O(N*2)
    // SC : O(4)
    private static int funcSpaceOptimization(int[] a) {
        int n = a.length;
        int[] prev = new int[2];
        for (int index = 1; index <= n; index++) {
            int[] curr = new int[2];
            for (int skip = 0; skip < 2; skip++) {
                int notTake = Integer.MAX_VALUE;
                if (skip == 1) {
                    notTake = prev[0];
                }
                int take = a[index - 1] + prev[1];
                curr[skip] = Math.min(take, notTake);
            }
            prev = curr;
        }
        return prev[1];
    }

    // Variable Solution
    // TC : O(N)
    // SC : O(1)
    private static int funcVariableSolution(int[] a) {
        int n = a.length;
        int prev0 = 0;
        int prev1 = 1;
        for (int index = 1; index <= n; index++) {
            int take = a[index - 1] + prev1;
            int curr1 = Math.min(take, prev0);
            prev0 = take;
            prev1 = curr1;
        }
        return prev1;
    }
}
