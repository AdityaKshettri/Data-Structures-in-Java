package com.aditya.project.sort;

// TC : O(NlogN)
// SC : O(N)
// Divide & Conquer
public class _MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};
        System.out.println("Given Array :");
        print(a);
        sort(a, 0, a.length - 1);
        System.out.println("Sorted Array :");
        print(a);
    }

    private static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {

        // Find sizes of two subArrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create Left & Right temp Arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }

        int i = 0, j = 0; // Initial indexes of Left & Right subArrays
        int k = l; // Initial index of merged subArray

        // Comparing & Arranging data in merged SubArray
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            a[k++] = L[i++];
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
