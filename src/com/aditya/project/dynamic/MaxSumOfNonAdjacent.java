package com.aditya.project.dynamic;

// Time Complexity: O(N)
// Auxiliary Space: O(1)
public class MaxSumOfNonAdjacent {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        print(a);
        System.out.println("Max Sum Of Non Adjacent Elements : " + maxSumOfNonAdjacent(a));
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static int maxSumOfNonAdjacent(int[] a) {
        int prev = a[0];
        int prev2 = 0;
        for (int i = 1; i < a.length; i++) {
            int take = a[i];
            if (i > 1) {
                take += prev2;
            }
            int nonTake = prev;
            int c = Math.max(take, nonTake);
            prev2 = prev;
            prev = c;
        }
        return prev;
    }
}
