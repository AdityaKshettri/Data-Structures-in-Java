package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("kth permutation = " + getKthPermutation(n, k));
    }

    private static String getKthPermutation(int n, int k) {
        String res = "";
        k--;
        int fact = 1;
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            num.add(i);
        }
        num.add(n);
        while (true) {
            res = res + num.get(k / fact);
            num.remove(k / fact);
            if (num.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        }
        return res;
    }
}
