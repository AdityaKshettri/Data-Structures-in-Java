package com.aditya.project.array.operation;

public class RemoveDuplicateFromSorted {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 3};
        print(a);
        int k = removeDuplicates(a);
        print(a, k);
    }

    // TC : O(N)
    // SC : O(1)
    private static int removeDuplicates(int[] a) {
        int c = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[c]) {
                c++;
                a[c] = a[i];
            }
        }
        return c + 1;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static void print(int[] a, int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}
