package com.aditya.project.array.pointer3;

public class Sort0s1s2s {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 2, 1, 0};
        System.out.println("Given Array :");
        print(a);
        sort0s1s2s(a);
        System.out.println("Sorted Array :");
        print(a);
    }

    // Dutch National Flag Algorithm
    // Time Complexity: O(N)
    // Auxiliary Space: O(1)
    private static void sort0s1s2s(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;
        while (mid <= high) {
            switch (a[mid]) {
                case 0 -> swap(a, low++, mid++);
                case 1 -> mid++;
                case 2 -> swap(a, mid, high--);
            }
        }
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
