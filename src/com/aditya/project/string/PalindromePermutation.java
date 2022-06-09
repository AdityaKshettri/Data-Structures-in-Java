package com.aditya.project.string;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

    public static void main(String[] args) {
        String a = "aab";
        System.out.println("Palindrome Permutation possible (Brute Force) : " + funcBruteForce(a));
        System.out.println("Palindrome Permutation possible (HashSet) : " + funcHashSet(a));
    }

    // Brute Force
    // TC : O(N^2)
    // SC : O(N)
    private static boolean funcBruteForce(String a) {
        int n = a.length();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == a.charAt(j)) {
                    c[i]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] <= 1) {
                count++;
            }
        }
        return count <= 1;
    }

    // HashSet
    // TC : O(N)
    // SC : O(N)
    private static boolean funcHashSet(String a) {
        int n = a.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = a.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
