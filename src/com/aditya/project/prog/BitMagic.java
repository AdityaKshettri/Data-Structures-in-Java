package com.aditya.project.prog;

import java.util.Arrays;

public class BitMagic {

    public static void main(String[] args) {

        System.out.println();

        int n = 8;
        System.out.println("Position of first set bit for " + n + " from right : " + getFirstSetBitFromRight(n));

        System.out.println();

        n = 5;
        int k = 3;
        System.out.println("Checking if " + k + "th bit set for " + n + " using << : " + checkIfKthBitSetUsingLeftShift(n, k));
        System.out.println("Checking if " + k + "th bit set for " + n + " using >> : " + checkIfKthBitSetUsingRightShift(n, k));

        System.out.println();

        n = 5;
        System.out.println("Count of set bits for " + n + " = " + countSetBits(n));

        System.out.println();

        n = 8;
        System.out.println("Checking if " + n + " is power of 2 = " + checkIfPowerOf2(n));

        System.out.println();

        int[] a = {1, 1, 2, 2, 3, 4, 4};
        System.out.println("Odd Occurring no. in " + Arrays.toString(a) + " = " + findOneOddOccurring(a));

        System.out.println();

        n = 5;
        a = new int[]{1, 2, 4, 5};
        System.out.println("Missing no. in consecutive list " + Arrays.toString(a) + " = " + findMissingNoInConsecutiveList(a, n));

        System.out.println();

        String s = "abc";
        System.out.println("Power Set for " + s + " : " );
        generatePowerSet(s);

        System.out.println();
    }

    // get first set bit from right
    // O(1)
    public static int getFirstSetBitFromRight(int n){
        return (int)((Math.log10(n & -n))/Math.log10(2)) + 1;
    }

    // check if kth bit set using <<
    // O(1)
    public static boolean checkIfKthBitSetUsingLeftShift(int n, int k) {
        return (n & (1 << k - 1)) != 0;
    }

    // check if kth bit set using >>
    // O(1)
    public static boolean checkIfKthBitSetUsingRightShift(int n, int k) {
        return ((n >> k - 1) & 1) == 1;
    }

    // count set bits
    // Brian Kerningam's Algo
    // O(set bit count)
    public static int countSetBits(int n) {
        int c = 0;
        while (n > 0) {
            n = n & (n - 1);
            c++;
        }
        return c;
    }

    // check if n is power of 2
    // logic : only 1 bit will be set
    // Brian Kerningam's Algo
    // O(1)
    public static boolean checkIfPowerOf2(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    // find one odd occurring no. in array
    // O(n)
    public static int findOneOddOccurring(int[] a) {
        int x = 0;
        for (int j : a) {
            x = x ^ j;
        }
        return x;
    }

    // find missing no. in consecutive list
    // O(n)
    public static int findMissingNoInConsecutiveList(int[] a, int n) {
        int x = 0;
        for (int j : a) {
            x = x ^ j;
        }
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        return x;
    }

    // generate power set for given string
    // O(n * 2^n)
    public static void generatePowerSet(String a) {
        int n = a.length();
        int p = (int) Math.pow(2, n);
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    System.out.print(a.charAt(j));
                }
            }
            System.out.print("\t");
        }
    }

    public static boolean isSparse(int n)
    {
        // Your code here
        return (n & (n>>1)) == 0;
    }
}
