package com.aditya.project.array.find;

public class MaxConsecutive1s {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        System.out.println("Max Consecutive 1s : " + findMaxConsecutive1s(a));
    }

    // TC : O(N)
    // SC : O(1)
    private static int findMaxConsecutive1s(int[] a) {
        int c = 0;
        int max = 0;
        for (int i : a) {
            if (i == 1) {
                c++;
            } else {
                c = 0;
            }
            max = Math.max(max, c);
        }
        return max;
    }
}
