package com.aditya.project.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence (Brute Force) : " + funcBruteForce(a));
        System.out.println("Longest Consecutive Sequence (Hash Set) : " + funcHashSet(a));
    }

    // TC : O(NlogN)
    // SC : O(1)
    private static int funcBruteForce(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int c = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] == 1) {
                c++;
            }
            max = Math.max(max, c);
        }
        return max;
    }

    // TC : O(N)
    // SC : O(N)
    private static int funcHashSet(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        int max = 0;
        for (int i : a) {
            if (!set.contains(i - 1)) {
                int temp = i;
                int count = 1;
                while (set.contains(temp + 1)) {
                    temp++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
