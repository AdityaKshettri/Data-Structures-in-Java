package com.aditya.project.dynamic.partition;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String a = "catsanddog";
        List<String> dict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> res = new ArrayList<>();
        int n = a.length();
        func(0, n, a, dict, "", res);
        System.out.println(res);
    }

    // Recursion
    // TC : O(exponential)
    // SC : O(N)
    private static void func(int index, int n, String a, List<String> dict, String s, List<String> res) {
        if (index == n) {
            res.add(s.trim());
        }
        for (int i = index; i < n; i++) {
            String word = a.substring(index, i + 1);
            if (dict.contains(word)) {
                func(i + 1, n, a, dict, s + word + " ", res);
            }
        }
    }
}
