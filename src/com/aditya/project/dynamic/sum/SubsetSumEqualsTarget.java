package com.aditya.project.dynamic.sum;

import java.util.Arrays;

public class SubsetSumEqualsTarget {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int target = 5;
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
    private static boolean funcRecursion(int index, int target, int[] a) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return a[0] == target;
        }
        boolean notTake = funcRecursion(index - 1, target, a);
        boolean take = false;
        if (target - a[index] >= 0) {
            take = funcRecursion(index - 1, target - a[index], a);
        }
        return take || notTake;
    }

    // Memoization
    // TC : O(N*T)
    // SC : O(N*T) + O(T) (for Recursion)
    private static boolean funcMemoization(int index, int target, int[] a, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return a[0] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        boolean notTake = funcMemoization(index - 1, target, a, dp);
        boolean take = false;
        if (target - a[index] >= 0) {
            take = funcMemoization(index - 1, target - a[index], a, dp);
        }
        boolean res = take || notTake;
        dp[index][target] = res ? 1 : 0;
        return res;
    }

    // Tabulation
    // TC : O(N*T)
    // SC : O(N*T)
    private static boolean funcTabulation(int[] a, int target) {
        int n = a.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][a[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                boolean notTake = dp[i - 1][t];
                boolean take = false;
                if (t - a[i] >= 0) {
                    take = dp[i - 1][t - a[i]];
                }
                dp[i][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }

    // Space Optimization
    // TC : O(N*T)
    // SC : O(T)
    public static boolean funcSpaceOptimization(int[] a, int target) {
        int n = a.length;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        prev[a[0]] = true;
        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int t = 0; t <= target; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t - a[i] >= 0) {
                    take = prev[t - a[i]];
                }
                curr[t] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
