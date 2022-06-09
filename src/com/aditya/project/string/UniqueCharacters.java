package com.aditya.project.string;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueCharacters {

    public static void main(String[] args) {
        String a = "aditya";
        System.out.println("Has Unique Characters (Brute Force) : " + funcBruteForce(a));
        System.out.println("Has Unique Characters (Sorting) : " + funcSorting(a));
        System.out.println("Has Unique Characters (HashSet) : " + funcHashSet(a));
    }

    // Brute Force
    // TC : O(N^2)
    // SC : O(1)
    private static boolean funcBruteForce(String a) {
        int n = a.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && a.charAt(i) == a.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Sorting
    // TC : O(NlogN)
    // SC : O(N)
    private static boolean funcSorting(String a) {
        int n = a.length();
        char[] c = a.toCharArray();
        Arrays.sort(c);
        for (int i = 1; i < n; i++) {
            if (c[i] == c[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Sorting
    // TC : O(N)
    // SC : O(N)
    private static boolean funcHashSet(String a) {
        int n = a.length();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = a.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
