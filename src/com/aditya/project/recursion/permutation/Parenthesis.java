package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static void main(String[] args) {
        int n = 3;
        List<String> res = new ArrayList<>();
        func(n, "", 0, 0, res);
        System.out.println(res);
    }

    // TC : O(exponential)
    // SC : O(N)
    private static void func(int n, String s, int open, int close, List<String> res) {
        if (open == n && close == n) {
            res.add(s);
            return;
        }
        if (open < n) {
            func(n, s + "(", open + 1, close, res);
        }
        if (close < open) {
            func(n, s + ")", open, close + 1, res);
        }
    }
}
