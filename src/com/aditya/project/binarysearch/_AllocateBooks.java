package com.aditya.project.binarysearch;

public class _AllocateBooks {

    public static void main(String[] args) {
        int[] a = {12, 34, 67, 90};
        int n = 2;
        System.out.println("Minimum no. of pages allocated : " + allocateBooks(a, n));
    }

    // TC : O(NlogN)
    // SC : O(1)
    private static int allocateBooks(int[] a, int n) {
        if (n > a.length) {
            return -1;
        }
        int low = a[0];
        int high = 0;
        for (int i : a) {
            high += i;
            low = Math.min(low, i);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isAllocationPossible(a, n, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isAllocationPossible(int[] a, int n, int limit) {
        int c = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > limit) {
                return false;
            }
            if (sum + a[i] > limit) {
                c++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        if (c < n) {
            return true;
        }
        return false;
    }
}
