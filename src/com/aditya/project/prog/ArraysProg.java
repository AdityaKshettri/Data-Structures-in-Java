package com.aditya.project.prog;

public class ArraysProg {

    public static void main(String[] args) {

        System.out.println();

        int n = 3;
        int[] arr = new int[]{10, 20, 15};
        System.out.println("n : " + n);
        System.out.print("Array : ");
        java.util.Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Largest Element index : " + getLargestElementIndex(arr, n));
    }

    // O(n)
    private static int getLargestElementIndex(int[] a, int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[res]) {
                res = i;
            }
        }
        return res;
    }
}
