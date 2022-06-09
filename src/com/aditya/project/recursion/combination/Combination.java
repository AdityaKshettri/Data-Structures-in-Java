package com.aditya.project.recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{3, 1, 2};
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        List<List<Integer>> res = new ArrayList<>();
        System.out.println("Power Set :");
        func(0, n, a, new ArrayList<>(), res);
        System.out.println(res);
        res = new ArrayList<>();
        System.out.println("Power Set In Reverse:");
        funcReverse(0, n, a, new ArrayList<>(), res);
        System.out.println(res);
    }

    // Power Set
    // TC : O(2^N)
    // SC : O(N)
    private static void func(int i, int n, int[] a, List<Integer> curr, List<List<Integer>> res) {
        if (i == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(a[i]);
        func(i + 1, n, a, curr, res);
        curr.remove(curr.size() - 1);
        func(i + 1, n, a, curr, res);
    }

    // Power Set Reverse
    // TC : O(2^N)
    // SC : O(N)
    private static void funcReverse(int i, int n, int[] a, List<Integer> curr, List<List<Integer>> res) {
        if (i == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        funcReverse(i + 1, n, a, curr, res);
        curr.add(a[i]);
        funcReverse(i + 1, n, a, curr, res);
        curr.remove(curr.size() - 1);
    }
}
