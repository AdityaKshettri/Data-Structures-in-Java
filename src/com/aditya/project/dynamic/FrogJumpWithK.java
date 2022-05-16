package com.aditya.project.dynamic;

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
        System.out.println("Min frog jumps taking 1,2...k steps to reach n = " + func(n, a, dp, k));
    }

    private static int func(int n, int[] a, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    int jump = dp[i - j] + Math.abs(a[i] - a[i - j]);
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
