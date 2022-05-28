package com.aditya.project.dp;

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        int n = 4;
        int[] a = {10, 20, 30, 10};
        System.out.println("n = " + n);
        System.out.println("Array : ");
        print(a);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Min frog jumps taking 1 or 2 steps to reach n (Recursion) = " + funcRecursion(n - 1, a));
        System.out.println("Min frog jumps taking 1 or 2 steps to reach n (Memoization) = " + funcMemoization(n - 1, a, dp));
        System.out.println("Min frog jumps taking 1 or 2 steps to reach n (Tabulation) = " + funcTabulation(a));
        System.out.println("Min frog jumps taking 1 or 2 steps to reach n (Space Optimization) = " + funcSpaceOptimization(a));
    }

    // Recursion
    // TC : O(2^N)
    // SC : O(N)
    private static int funcRecursion(int index, int[] a) {
        if (index == 0) {
            return 0;
        }
        int way1 = Math.abs(a[index] - a[index - 1]) + funcRecursion(index - 1, a);
        int way2 = Integer.MAX_VALUE;
        if (index > 1) {
            way2 = Math.abs(a[index] - a[index - 2]) + funcRecursion(index - 2, a);
        }
        return Math.min(way1, way2);
    }

    // Memoization
    // TC : O(N)
    // SC : O(N) + O(N) for recursion
    private static int funcMemoization(int index, int[] a, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int way1 = Math.abs(a[index] - a[index - 1]) + funcMemoization(index - 1, a, dp);
        int way2 = Integer.MAX_VALUE;
        if (index > 1) {
            way2 = Math.abs(a[index] - a[index - 2]) + funcMemoization(index - 2, a, dp);
        }
        return dp[index] = Math.min(way1, way2);
    }

    // Tabulation
    // TC : O(N)
    // SC : O(N)
    private static int funcTabulation(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int way1 = Math.abs(a[i] - a[i - 1]) + dp[i - 1];
            int way2 = Integer.MAX_VALUE;
            if (i > 1) {
                way2 = Math.abs(a[i] - a[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(way1, way2);
        }
        return dp[n - 1];
    }

    // Space Optimization
    // TC : O(N)
    // SC : O(1)
    private static int funcSpaceOptimization(int[] a) {
        int prev2 = 0;
        int prev = 0;
        for (int i = 1; i < a.length; i++) {
            int way1 = Math.abs(a[i] - a[i - 1]) + prev;
            int way2 = Integer.MAX_VALUE;
            if (i > 1) {
                way2 = Math.abs(a[i] - a[i - 2]) + prev2;
            }
            int curr = Math.min(way1, way2);
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
