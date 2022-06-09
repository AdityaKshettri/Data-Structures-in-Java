package com.aditya.project.binarysearch.sorted;

public class MagicIndex {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, 4, 10};
        System.out.println("Magic Index in Sorted Array (Brute Force) : " + funcBruteForce(a));
        System.out.println("Magic Index in Sorted Array (Binary Search) : " + funcBinarySearch(a));
    }

    // TC : O(N)
    // SC : O(1)
    private static int funcBruteForce(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == i) {
                return i;
            }
        }
        return -1;
    }

    // TC : O(logN)
    // SC : O(1)
    private static int funcBinarySearch(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == mid) {
                return mid;
            } else if (a[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
