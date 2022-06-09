package com.aditya.project.array.find;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        print(a);
        System.out.println("Max SubArray Sum : " + maxSubArraySum(a));
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    // Kadane's Algo
    // Time Complexity: O(N)
    // Auxiliary Space: O(1)
    private static int maxSubArraySum(int[] a) {
        int sum = 0;
        int max = a[0];
        for (int i : a) {
            sum += i;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
