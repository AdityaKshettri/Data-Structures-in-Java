package com.aditya.project.dp.sum;

import java.util.Arrays;

public class MaxSumOfNonAdjacent {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int n = a.length;
        print(a);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Max Sum Of Non Adjacent Elements : (Recursion) = " + funcRecursion(n - 1, a));
        System.out.println("Max Sum Of Non Adjacent Elements : (Memoization) = " + funcMemoization(n - 1, a, dp));
        System.out.println("Max Sum Of Non Adjacent Elements : (Tabulation) = " + funcTabulation(a));
        System.out.println("Max Sum Of Non Adjacent Elements : (Space Optimization) = " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^N)
    // TC : O(N)
    private static int funcRecursion(int index, int[] a) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return a[0];
        }
        int notTake = funcRecursion(index - 1, a);
        int take = a[index] + funcRecursion(index - 2, a);
        return Math.max(take, notTake);
    }

    // Memoization
    // TC : O(N)
    // TC : O(N) + O(N) for Recursion
    private static int funcMemoization(int index, int[] a, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return a[0];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int notTake = funcRecursion(index - 1, a);
        int take = a[index] + funcRecursion(index - 2, a);
        return dp[index] = Math.max(take, notTake);
    }

    // Tabulation
    // TC : O(N)
    // TC : O(N)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            int nonTake = dp[i - 1];
            int take = a[i];
            if (i > 1) {
                take += dp[i - 2];
            }
            dp[i] = Math.max(take, nonTake);
        }
        return dp[n - 1];
    }

    // Space Optimization
    // TC : O(N)
    // TC : O(1)
    public static int funcSpaceOptimization(int[] a) {
        int prev2 = 0;
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            int nonTake = prev;
            int take = a[i];
            if (i > 1) {
                take += prev2;
            }
            int curr = Math.max(take, nonTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
