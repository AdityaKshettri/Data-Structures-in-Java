package com.aditya.project.bs;

public class SmallestElementInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Index of target in array : " + search(a));
    }

    // TC : O(logN)
    // SC : O(1)
    private static int search(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] > a[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return a[high];
    }
}
