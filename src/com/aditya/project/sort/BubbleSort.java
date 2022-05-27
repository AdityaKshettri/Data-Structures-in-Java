package com.aditya.project.sort;

// TC : O(N^2)
// SC : O(1)
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};
        System.out.println("Given Array :");
        print(a);
        bubbleSort(a);
        System.out.println("Sorted Array :");
        print(a);
    }

    private static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
