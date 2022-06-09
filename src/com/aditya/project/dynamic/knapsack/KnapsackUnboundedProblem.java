package com.aditya.project.dynamic.knapsack;

import java.util.Arrays;

public class KnapsackUnboundedProblem {

    public static void main(String[] args) {
        int[] w = {3, 2, 5};
        int[] v = {30, 40, 60};
        int weight = 6;
        int n = w.length;
        int[][] dp = new int[n][weight + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println("(Recursion) : " + funcRecursion(n - 1, w, v, weight));
        System.out.println("(Memoization) : " + funcMemoization(n - 1, w, v, weight, dp));
        System.out.println("(Tabulation) : " + funcTabulation(w, v, weight));
        System.out.println("(Space Optimization) : " + funcSpaceOptimization(w, v, weight));
    }

    // Recursion
    // TC : O(>>2^N)
    // SC : O(W)
    private static int funcRecursion(int index, int[] w, int[] v, int weight) {
        if (index == 0) {
            return weight / w[0] * v[0];
        }
        int notTake = funcRecursion(index - 1, w, v, weight);
        int take = Integer.MIN_VALUE;
        if (weight - w[index] >= 0) {
            take = v[index] + funcRecursion(index, w, v, weight - w[index]);
        }
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N*W)
    // SC : O(N*W) + O(W) (for Recursion)
    private static int funcMemoization(int index, int[] w, int[] v, int weight, int[][] dp) {
        if (index == 0) {
            return weight / w[0] * v[0];
        }
        if (dp[index][weight] != -1) {
            return dp[index][weight];
        }
        int notTake = funcMemoization(index - 1, w, v, weight, dp);
        int take = Integer.MIN_VALUE;
        if (weight - w[index] >= 0) {
            take = v[index] + funcMemoization(index, w, v, weight - w[index], dp);
        }
        return dp[index][weight] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N*W)
    // SC : O(N*W)
    private static int funcTabulation(int[] w, int[] v, int weight) {
        int n = w.length;
        int[][] dp = new int[n][weight + 1];
        for (int i = 0; i <= weight; i++) {
            dp[0][i] = i / w[0] * v[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= weight; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (j - w[i] >= 0) {
                    take = v[i] + dp[i][j - w[i]];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][weight];
    }

    // Space Optimization
    // TC : O(N*W)
    // SC : O(W)
    private static int funcSpaceOptimization(int[] w, int[] v, int weight) {
        int n = w.length;
        int[] prev = new int[weight + 1];
        for (int i = 0; i <= weight; i++) {
            prev[i] = i / w[0] * v[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= weight; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (j - w[i] >= 0) {
                    take = v[i] + prev[j - w[i]];
                }
                prev[j] = Math.max(take, notTake);
            }
        }
        return prev[weight];
    }
}
