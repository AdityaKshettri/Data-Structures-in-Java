package com.aditya.project.array.pointer2;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 4, 8, 10);
        List<Integer> b = List.of(1, 2, 9, 15);
        System.out.println(func(a, b));
    }

    // TC : O(N+M)
    // SC : O(N+M)
    private static List<Integer> func(List<Integer> a, List<Integer> b) {
        int n = a.size();
        int m = b.size();
        List<Integer> c = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a.get(i) <= b.get(j)) {
                c.add(a.get(i++));
            } else {
                c.add(b.get(j++));
            }
        }
        while (i < n) {
            c.add(a.get(i++));
        }
        while (j < m) {
            c.add(b.get(j++));
        }
        return c;
    }
}
