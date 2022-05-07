package com.aditya.project.array.hashing;

import java.util.HashMap;

public class SubArraysWithGivenXOR {

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        System.out.println("Array :");
        print(a);
        int b = 6;
        System.out.println("Given XOR : " + b);
        System.out.println("Count of SubArrays with Given XOR : " + getSubArraysWithGivenXOR(a, b));
    }

    private static int getSubArraysWithGivenXOR(int[] a, int b) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int xor = 0;
        for (int i : a) {
            xor ^= i;
            if (freq.get(xor ^ b) != null) {
                count += freq.get(xor ^ b);
            }
            if (xor == b) {
                count++;
            }
            if (freq.get(xor) != null) {
                freq.put(xor, freq.get(xor) + 1);
            } else {
                freq.put(xor, 1);
            }
        }
        return count;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
