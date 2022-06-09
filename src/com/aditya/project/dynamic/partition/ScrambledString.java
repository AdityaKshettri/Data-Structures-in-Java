package com.aditya.project.dynamic.partition;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

    public static void main(String[] args) {
        String a = "great";
        String b = "rgate";
        Map<String, Boolean> map = new HashMap<>();
        System.out.println("Scrambled String (Recursion) : " + funcRecursion(a, b));
        System.out.println("Scrambled String (Tabulation) : " + funcTabulation(a, b, map));
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(exponential)
    private static boolean funcRecursion(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }
        int n = a.length();
        char[] c = new char[26];
        for (int i = 0; i < n; i++) {
            c[a.charAt(i) - 'a']++;
            c[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            if (funcRecursion(a.substring(0, i), b.substring(0, i)) && funcRecursion(a.substring(i, n), b.substring(i, n))) {
                return true;
            }
            if (funcRecursion(a.substring(n - i, n), b.substring(0, i)) && funcRecursion(a.substring(0, n - i), b.substring(i, n))) {
                return true;
            }
        }
        return false;
    }

    // Tabulation
    // TC : O(N^2)
    // SC : O(N^2)
    private static boolean funcTabulation(String a, String b, Map<String, Boolean> map) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }
        int n = a.length();
        char[] c = new char[26];
        for (int i = 0; i < n; i++) {
            c[a.charAt(i) - 'a']++;
            c[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        String key = a + "-" + b;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1; i < n; i++) {
            if (funcTabulation(a.substring(0, i), b.substring(0, i), map) && funcTabulation(a.substring(i, n), b.substring(i, n), map)) {
                return true;
            }
            if (funcTabulation(a.substring(n - i, n), b.substring(0, i), map) && funcTabulation(a.substring(0, n - i), b.substring(i, n), map)) {
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
