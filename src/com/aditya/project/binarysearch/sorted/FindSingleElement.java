package com.aditya.project.binarysearch.sorted;

public class FindSingleElement {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single Element in Sorted Array (Brute Force) : " + funcBruteForce(a));
        System.out.println("Single Element in Sorted Array (Binary Search) : " + funcBinarySearch(a));
    }

    // TC : O(N)
    // SC : O(1)
    private static int funcBruteForce(int[] a) {
        int xor = 0;
        for (int i : a) {
            xor ^= i;
        }
        return xor;
    }

    // TC : O(logN)
    // SC : O(1)
    private static int funcBinarySearch(int[] a) {
        int low = 0;
        int high = a.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == a[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return a[low];
    }
}
