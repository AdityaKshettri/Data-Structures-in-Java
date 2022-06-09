package com.aditya.project.array.operation;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = new ArrayList<>();
        generatePascalsTriangle(n, res);
        System.out.println(res);
    }

    private static void generatePascalsTriangle(int n, List<List<Integer>> res) {
        List<Integer> pre = null;
        for (int i = 0; i < n; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = curr;
            res.add(curr);
        }
    }
}
