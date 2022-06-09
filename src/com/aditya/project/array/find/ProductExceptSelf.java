package com.aditya.project.array.find;

import java.util.Arrays;

// Note: Division Not Allowed
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println("Brute Force:");
        int[] res = funcBruteForce(a);
        print(res);
        System.out.println("Optimized:");
        res = funcOptimized(a);
        print(res);
        System.out.println("Space Optimized:");
        res = funcSpaceOptimized(a);
        print(res);
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    // TC : O(N^2)
    // SC : O(1)
    private static int[] funcBruteForce(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    res[i] *= a[j];
                }
            }
        }
        return res;
    }

    // TC : O(N)
    // SC : O(N)
    private static int[] funcOptimized(int[] a) {
        int n = a.length;
        int[] l = new int[n];
        l[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            l[i + 1] = l[i] * a[i];
        }
        int[] r = new int[n];
        r[n - 1] = 1;
        for (int i = n - 1; i > 0; i--) {
            r[i - 1] = r[i] * a[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }

    // TC : O(N)
    // SC : O(1)
    private static int[] funcSpaceOptimized(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            res[i + 1] = res[i] * a[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }
}
