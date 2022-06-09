package com.aditya.project.dynamic.coins;

import java.util.Arrays;

public class MinCoinsProblem {

    public static void main(String[] args) {
        int[] a = {9, 5, 4, 1};
        int target = 11;
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Minimum no. of coins required (Recursion) : " + modifyOutput(funcRecursion(n - 1, a, target)));
        System.out.println("Minimum no. of coins required (Memoization) : " + modifyOutput(funcMemoization(n - 1, a, target, dp)));
        System.out.println("Minimum no. of coins required (Tabulation) : " + modifyOutput(funcTabulation(a, target)));
        System.out.println("Minimum no. of coins required (SpaceOptimization) : " + modifyOutput(funcSpaceOptimization(a, target)));
    }

    // Recursion
    // TC : O(>>2^N)
    // SC : O(T)
    private static int funcRecursion(int index, int[] a, int target) {
        if (index == 0) {
            if (target % a[0] == 0) {
                return target / a[0];
            }
            return (int) 1e9;
        }
        int notTake = funcRecursion(index - 1, a, target);
        int take = Integer.MAX_VALUE;
        if (target - a[index] >= 0) {
            take = 1 + funcRecursion(index, a, target - a[index]);
        }
        return Math.min(take, notTake);
    }

    // Memoization
    // TC : O(N*T)
    // SC : O(N*T) + O(T) (for Recursion)
    private static int funcMemoization(int index, int[] a, int target, int[][] dp) {
        if (index == 0) {
            if (target % a[0] == 0) {
                return target / a[0];
            }
            return (int) 1e9;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = funcMemoization(index - 1, a, target, dp);
        int take = Integer.MAX_VALUE;
        if (target - a[index] >= 0) {
            take = 1 + funcMemoization(index, a, target - a[index], dp);
        }
        return dp[index][target] = Math.min(take, notTake);
    }

    // Tabulation
    // TC : O(N*T)
    // SC : O(N*T)
    private static int funcTabulation(int[] a, int target) {
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int t = 0; t <= target; t++) {
            if (t % a[0] == 0) {
                dp[0][t] = t / a[0];
            } else {
                dp[0][t] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int take = Integer.MAX_VALUE;
                if (t - a[i] >= 0) {
                    take = 1 + dp[i][t - a[i]];
                }
                dp[i][t] = Math.min(take, notTake);
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
        for (int t = 0; t <= target; t++) {
            if (t % a[0] == 0) {
                prev[t] = t / a[0];
            } else {
                prev[t] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = prev[t];
                int take = Integer.MAX_VALUE;
                if (t - a[i] >= 0) {
                    take = 1 + prev[t - a[i]];
                }
                prev[t] = Math.min(take, notTake);
            }
        }
        return prev[target];
    }

    private static int modifyOutput(int output) {
        if (output >= 1e9 || output == 0) {
            output = -1;
        }
        return output;
    }
}
