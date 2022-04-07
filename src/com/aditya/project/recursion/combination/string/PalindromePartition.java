package com.aditya.project.recursion.combination.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println("s = " + s);
        List<List<String>> ds = new ArrayList<>();
        getPalindromePartitions(0, s, new ArrayList<>(), ds);
        System.out.println(ds);
    }

    // Get Palindrome Partitions
    private static void getPalindromePartitions(int index, String s, List<String> curr, List<List<String>> ds) {
        if (index == s.length()) {
            ds.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                getPalindromePartitions(i + 1, s, curr, ds);
                curr.remove(curr.size() - 1);
            }
        }
    }

    // Checking if Palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
