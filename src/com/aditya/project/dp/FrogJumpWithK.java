package com.aditya.project.dp;

import java.util.Arrays;

public class FrogJumpWithK {

    public static void main(String[] args) {
        int n = 6;
        int[] a = {30, 10, 60, 10, 60, 50};
        int k = 2;
        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Array : ");
        print(a);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Min frog jumps taking 1,2...k steps to reach n (Recursion) = " + funcRecursion(n - 1, a, k));
        System.out.println("Min frog jumps taking 1,2...k steps to reach n (Memoization) = " + funcMemoization(n - 1, a, k, dp));
        System.out.println("Min frog jumps taking 1,2...k steps to reach n (Tabulation) = " + funcTabulation(a, k));
    }

    // Recursion
    // TC : O(2^N*K)
    // SC : O(N*K)
    private static int funcRecursion(int index, int[] a, int k) {
        if (index == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = Math.abs(a[index] - a[index - i]) + funcRecursion(index - i, a, k);
                min = Math.min(min, jump);
            }
        }
        return min;
    }

    // Memoization
    // TC : O(N*K)
    // SC : O(N) + O(N) for recursion
    private static int funcMemoization(int index, int[] a, int k, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = Math.abs(a[index] - a[index - i]) + funcMemoization(index - i, a, k, dp);
                min = Math.min(min, jump);
            }
        }
        return dp[index] = min;
    }

    // Tabulation
    // TC : O(N*K)
    // SC : O(N)
    private static int funcTabulation(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    int jump = Math.abs(a[i] - a[i - j]) + dp[i - j];
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
