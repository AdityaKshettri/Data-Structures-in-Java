package com.aditya.project.dynamic.prev;

import java.util.Arrays;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] a = {1, 4, 16, 8, 5};
        int n = a.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Largest Divisible Subset (Recursion) : " + funcRecursion(0, -1, a));
        System.out.println("Largest Divisible Subset (Memoization) : " + funcMemoization(0, -1, a, dp));
        System.out.println("Largest Divisible Subset (Tabulation) : " + funcTabulation(a));
        System.out.println("Largest Divisible Subset (Space Optimization) : " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int prev, int[] a) {
        if (index == a.length) {
            return 0;
        }
        int notTake = funcRecursion(index + 1, prev, a);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || a[prev] % a[index] == 0 || a[index] % a[prev] == 0) {
            take = 1 + funcRecursion(index + 1, index, a);
        }
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N^2)
    // SC : O(N^2) + O(N) for Recursion
    private static int funcMemoization(int index, int prev, int[] a, int[][] dp) {
        if (index == a.length) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }
        int notTake = funcMemoization(index + 1, prev, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || a[prev] % a[index] == 0 || a[index] % a[prev] == 0) {
            take = 1 + funcMemoization(index + 1, index, a, dp);
        }
        return dp[index][prev + 1] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N^2)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = dp[index + 1][prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || a[prev] % a[index] == 0 || a[index] % a[prev] == 0) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    // TC : O(N^2)
    // SC : O(N)
    private static int funcSpaceOptimization(int[] a) {
        int n = a.length;
        int[] next = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[n + 1];
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = next[prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || a[prev] % a[index] == 0 || a[index] % a[prev] == 0) {
                    take = 1 + next[index + 1];
                }
                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }
}
