package com.aditya.project.binarysearch.rotatedsorted;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {3, 3, 1, 3};
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
            } else if (a[mid] < a[high]) {
                high = mid;
            } else {
                high--;// handling duplicate case
            }
        }
        return a[high];
    }
}
