package com.aditya.project.array.find;

// Time Complexity: O(N)
// Auxiliary Space: O(1)
public class MaxSubArrayProduct {

    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        print(a);
        System.out.println("Max SubArray Product : " + maxSubArrayProduct(a));
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static int maxSubArrayProduct(int[] a) {
        int min = a[0];
        int max = a[0];
        int product = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                int t = min;
                min = max;
                max = t;
            }
            min = Math.min(a[i], min * a[i]);
            max = Math.max(a[i], max * a[i]);
            product = Math.max(product, max);
        }
        return product;
    }
}
