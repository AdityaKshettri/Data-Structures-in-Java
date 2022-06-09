package com.aditya.project.array.pointer2;

// Time Complexity: O(N+M)
// Auxiliary Space: O(1)
// 2 pointer method
public class MergeSortedArrays {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        System.out.println("Array a :");
        print(a);
        System.out.println("Array b :");
        print(b);
        System.out.println("After merging sorted Array a and b :");
        mergeSortedArrays(a, m, b, n);
        print(a);
    }

    public static void mergeSortedArrays(int[] a, int m, int[] b, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && a[p1] > b[p2]) {
                a[i--] = a[p1--];
            } else {
                a[i--] = b[p2--];
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
