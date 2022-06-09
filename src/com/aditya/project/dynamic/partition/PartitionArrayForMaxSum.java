package com.aditya.project.dynamic.partition;

import java.util.Arrays;

public class PartitionArrayForMaxSum {

    public static void main(String[] args) {
        int k = 3;
        int[] a = {1, 15, 7, 9, 2, 5, 10};
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Max Sum Partition Array (Recursion) : " + funcRecursion(0, k, n, a));
        System.out.println("Max Sum Partition Array (Memoization) : " + funcMemoization(0, k, n, a, dp));
        System.out.println("Max Sum Partition Array (Tabulation) : " + funcTabulation(k, n, a));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static int funcRecursion(int i, int k, int n, int[] a) {
        if (i == n) {
            return 0;
        }
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(n, i + k); j++) {
            len++;
            maxi = Math.max(maxi, a[j]);
            int sum = len * maxi + funcRecursion(j + 1, k, n, a);
            max = Math.max(max, sum);
        }
        return max;
    }

    // Memoization
    // TC : O(N*K)
    // SC : O(N) + O(N) for Recursion
    private static int funcMemoization(int i, int k, int n, int[] a, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(n, i + k); j++) {
            len++;
            maxi = Math.max(maxi, a[j]);
            int sum = len * maxi + funcMemoization(j + 1, k, n, a, dp);
            max = Math.max(max, sum);
        }
        return dp[i] = max;
    }

    // Tabulation
    // TC : O(N*K)
    // SC : O(N)
    private static int funcTabulation(int k, int n, int[] a) {
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxi = Math.max(maxi, a[j]);
                int sum = len * maxi + dp[j + 1];
                max = Math.max(max, sum);
            }
            dp[i] = max;
        }
        return dp[0];
    }
}
