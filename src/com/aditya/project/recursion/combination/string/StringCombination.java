package com.aditya.project.recursion.combination.string;

public class StringCombination {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Subsets for string s : " + s);
        generateAnagrams(s, "", 0);
    }

    // Generate Subsets
    private static void generateAnagrams(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.print(curr + "\t");
            return;
        }
        generateAnagrams(s, curr + s.charAt(i), i + 1);
        generateAnagrams(s, curr, i + 1);
    }
}
