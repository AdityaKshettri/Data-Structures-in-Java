package com.aditya.project.sort;

// TC : O(NlogN)
// SC : O(logN)
public class QuickSort {

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
            int pivot = partition(a, l, r);
            sort(a, l, pivot - 1);
            sort(a, pivot + 1, r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
