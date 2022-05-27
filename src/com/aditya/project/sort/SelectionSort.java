package com.aditya.project.sort;

// TC : O(N^2)
// SC : O(1)
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};
        System.out.println("Given Array :");
        print(a);
        selectionSort(a);
        System.out.println("Sorted Array :");
        print(a);
    }

    private static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
