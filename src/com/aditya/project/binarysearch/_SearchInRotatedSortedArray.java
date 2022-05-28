package com.aditya.project.binarysearch;

public class _SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 0;
        System.out.println("Index of target in array : " + search(a, target));
    }

    // TC : O(logN)
    // SC : O(1)
    private static int search(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[low] <= a[mid]) {
                if (a[low] <= target && a[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (a[high] >= a[mid]) {
                if (a[high] >= target && a[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
