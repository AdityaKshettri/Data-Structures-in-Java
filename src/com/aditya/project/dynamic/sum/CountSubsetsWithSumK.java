package com.aditya.project.dynamic.sum;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int target = 3;
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("(Recursion) : " + funcRecursion(n - 1, target, a));
        System.out.println("(Memoization) : " + funcMemoization(n - 1, target, a, dp));
        System.out.println("(Tabulation) : " + funcTabulation(a, target));
        System.out.println("(Space Optimization) : " + funcSpaceOptimization(a, target));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int target, int[] a) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            return target == a[0] ? 1 : 0;
        }
        int notTake = funcRecursion(index - 1, target, a);
        int take = 0;
        if (target - a[index] >= 0) {
            take = funcRecursion(index - 1, target - a[index], a);
        }
        return take + notTake;
    }

    // Memoization
    // TC : O(N*T)
    // SC : O(N*T) + O(N) for Recursion
    private static int funcMemoization(int index, int target, int[] a, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            return target == a[0] ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = funcMemoization(index - 1, target, a, dp);
        int take = 0;
        if (target - a[index] >= 0) {
            take = funcMemoization(index - 1, target - a[index], a, dp);
        }
        return dp[index][target] = take + notTake;
    }

    // Tabulation
    // TC : O(N*T)
    // SC : O(N*T)
    private static int funcTabulation(int[] a, int target) {
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        dp[0][a[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j - a[i] >= 0) {
                    take = dp[i - 1][j - a[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n - 1][target];
    }

    // Space Optimization
    // TC : O(N*T)
    // SC : O(T)
    private static int funcSpaceOptimization(int[] a, int target) {
        int n = a.length;
        int[] prev = new int[target + 1];
        prev[0] = 1;
        prev[a[0]] = 1;
        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = 0;
                if (j - a[i] >= 0) {
                    take = prev[j - a[i]];
                }
                curr[j] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
