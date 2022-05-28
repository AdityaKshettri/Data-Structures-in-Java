package com.aditya.project.greedy;

import java.util.Arrays;
import java.util.Collections;

// TC : O(N)
// SC : O(1)
public class CoinsProblem {

    public static void main(String[] args) {
        Integer[] a = {9, 5, 6, 1};
        int target = 11;
        Arrays.sort(a, Collections.reverseOrder());
        int c = 0;
        for (int i : a) {
            int n = target / i;
            c += n;
            target -= i * n;
        }
        if (target == 0) {
            System.out.println("Coins needed : " + c);
        }
    }
}
