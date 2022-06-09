package com.aditya.project.array.find;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};
        print(a);
        System.out.println("Duplicate Number in Array using XOR: " + findDuplicateUsingXOR(a));
        System.out.println("Duplicate Number in Array using Frequency Array: " + findDuplicateUsingFreqArray(a));
        System.out.println("Duplicate Number in Array Using Tortoise Method : " + findDuplicateUsingTortoiseMethod(a));
    }

    // Time Complexity: O(N)
    // Auxiliary Space: O(1)
    private static int findDuplicateUsingXOR(int[] a) {
        int n = a.length;
        int xor = 0;
        for (int i=1;i<n;i++) {
            xor = xor ^ i;
        }
        for (int i : a) {
            xor = xor ^ i;
        }
        return xor;
    }

    // Time Complexity: O(N)
    // Auxiliary Space: O(N)
    private static int findDuplicateUsingFreqArray(int[] a) {
        int n = a.length;
        int[] f = new int[n];
        for (int i : a) {
            f[i]++;
        }
        for (int i = 0; i < n; i++) {
            if (f[i] > 1) {
                return i;
            }
        }
        return 0;
    }

    // Time Complexity: O(N)
    // Auxiliary Space: O(1)
    // Tortoise Algorithm
    private static int findDuplicateUsingTortoiseMethod(int[] a) {
        int slow = a[0];
        int fast = a[0];
        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while (slow != fast);
        fast = a[0];
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
