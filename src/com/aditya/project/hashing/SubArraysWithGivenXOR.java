package com.aditya.project.hashing;

import java.util.HashMap;

public class SubArraysWithGivenXOR {

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int b = 6;
        System.out.println("Count of SubArrays with Given XOR (Brute Force) : " + funcBruteForce(a, b));
        System.out.println("Count of SubArrays with Given XOR (Hash Map): " + funcHashMap(a, b));
    }

    // TC : O(N*N*N)
    // SC : O(1)
    private static int funcBruteForce(int[] a, int b) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor ^= a[k];
                }
                if (xor == b) {
                    count++;
                }
            }
        }
        return count;
    }

    // TC : O(N)
    // SC : O(N)
    private static int funcHashMap(int[] a, int b) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int xor = 0;
        for (int i : a) {
            xor ^= i;
            if (xor == b) {
                count++;
            }
            if (freq.containsKey(xor ^ b)) {
                count += freq.get(xor ^ b);
            }
            if (freq.containsKey(xor)) {
                freq.put(xor, freq.get(xor) + 1);
            } else {
                freq.put(xor, 1);
            }
        }
        return count;
    }
}
