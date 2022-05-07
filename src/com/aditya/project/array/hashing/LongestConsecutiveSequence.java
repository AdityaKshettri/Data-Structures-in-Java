package com.aditya.project.array.hashing;

import java.util.HashSet;

// Time Complexity: O(N)
// Auxiliary Space: O(N)
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println("Array :");
        print(a);
        System.out.println("Longest Consecutive Sequence : " + getLongestConsecutiveSequence(a));
    }

    private static int getLongestConsecutiveSequence(int[] a) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : a) {
            hashSet.add(i);
        }
        int longestCount = 0;
        for (int i : a) {
            if (!hashSet.contains(i - 1)) {
                int temp = i;
                int count = 1;
                while (hashSet.contains(temp + 1)) {
                    temp++;
                    count++;
                }
                longestCount = Math.max(longestCount, count);
            }
        }
        return longestCount;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
