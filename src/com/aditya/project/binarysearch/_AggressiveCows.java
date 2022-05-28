package com.aditya.project.binarysearch;

import java.util.Arrays;

public class _AggressiveCows {

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 4, 9}; // Stalls
        int n = 3; // No. of cows
        System.out.println("Largest minimum distance between cows : " + allocateCows(a, n));
    }

    // TC : O(NlogN)
    // SC : O(1)
    private static int allocateCows(int[] a, int n) {
        Arrays.sort(a);
        int low = 1;
        int high = a[n - 1] - a[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isAllocationPossible(a, n, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean isAllocationPossible(int[] a, int n, int limit) {
        int c = 1;
        int curr = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - curr >= limit) {
                c++;
                curr = a[i];
            }
        }
        return c >= n;
    }
}
