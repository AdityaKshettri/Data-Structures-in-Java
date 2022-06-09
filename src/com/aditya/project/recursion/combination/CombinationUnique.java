package com.aditya.project.recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationUnique {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{1, 1, 2};
        System.out.print("Array : ");
        Arrays.stream(a).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Unique Power Set :");
        List<List<Integer>> res = new ArrayList<>();
        func(0, n, a, new ArrayList<>(), res);
        System.out.println(res);
    }

    // Power Set Unique
    // TC : O(2^N)
    // SC : O(N)
    private static void func(int index, int n, int[] a, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < n; i++) {
            if (i != index && a[i] == a[i - 1]) {
                continue;
            }
            curr.add(a[i]);
            func(i + 1, n, a, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
