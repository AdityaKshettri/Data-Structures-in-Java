package com.aditya.project.dynamic.cutting;

import java.util.Arrays;

public class RodCuttingMinCuts {

    public static void main(String[] args) {
        int[] a = {2, 5, 7, 8, 10};
        int target = 5;
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("Minimum cuts to be made (Recursion) : " + funcRecursion(n - 1, a, target));
        System.out.println("Minimum cuts to be made (Memoization) : " + funcMemoization(n - 1, a, target, dp));
        System.out.println("Minimum cuts to be made (Tabulation) : " + funcTabulation(a, target));
        System.out.println("Minimum cuts to be made (SpaceOptimization) : " + funcSpaceOptimization(a, target));
    }

    // Recursion
    // TC : O(>>2^N)
    // SC : O(T)
    private static int funcRecursion(int index, int[] a, int target) {
        if (index == 0) {
            return target * a[0];
        }
        int notTake = funcRecursion(index - 1, a, target);
        int rodLength = index + 1;
        int take = Integer.MIN_VALUE;
        if (target - rodLength >= 0) {
            take = a[index] + funcRecursion(index, a, target - rodLength);
        }
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N*T)
    // SC : O(N*T) + O(T) (for Recursion)
    private static int funcMemoization(int index, int[] a, int target, int[][] dp) {
        if (index == 0) {
            return target * a[0];
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = funcMemoization(index - 1, a, target, dp);
        int rodLength = index + 1;
        int take = Integer.MIN_VALUE;
        if (target - rodLength >= 0) {
            take = a[index] + funcMemoization(index, a, target - rodLength, dp);
        }
        return dp[index][target] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N*T)
    // SC : O(N*T)
    private static int funcTabulation(int[] a, int target) {
        int n = a.length;
        int[][] dp = new int[n][target + 1];
        for (int t = 0; t <= target; t++) {
            dp[0][t] = t * a[0];
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int rodLength = i + 1;
                int take = Integer.MIN_VALUE;
                if (t - rodLength >= 0) {
                    take = a[i] + dp[i][t - rodLength];
                }
                dp[i][t] = Math.max(take, notTake);
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
            prev[t] = t * a[0];
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = prev[t];
                int rodLength = i + 1;
                int take = Integer.MIN_VALUE;
                if (t - rodLength >= 0) {
                    take = a[i] + prev[t - rodLength];
                }
                prev[t] = Math.max(take, notTake);
            }
        }
        return prev[target];
    }
}
