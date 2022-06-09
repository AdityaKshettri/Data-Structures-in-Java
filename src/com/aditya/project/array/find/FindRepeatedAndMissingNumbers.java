package com.aditya.project.array.find;

import java.math.BigInteger;
import java.util.List;

// Time Complexity: O(N)
// Auxiliary Space: O(1)
public class FindRepeatedAndMissingNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 6, 7};
        System.out.println("Array :");
        print(arr);
        List<Integer> res = findRepeatedAndMissingNos(arr);
        System.out.println("Repeated number : " + res.get(0));
        System.out.println("Missing number : " + res.get(1));
    }

    // a = repeated number
    // b = missing number
    // b - a
    // b^2 - a^2
    private static List<Integer> findRepeatedAndMissingNos(int[] arr) {
        BigInteger n = BigInteger.valueOf(arr.length);
        BigInteger s = BigInteger.ZERO;
        BigInteger ss = BigInteger.ZERO;
        for (int i : arr) {
            BigInteger temp = BigInteger.valueOf(i);
            s = s.add(temp);
            ss = ss.add(temp.multiply(temp));
        }
        BigInteger sum = n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.TWO);
        BigInteger sqSum = sum.multiply(n.multiply(BigInteger.TWO).add(BigInteger.ONE)).divide(BigInteger.valueOf(3));
        BigInteger sub = sum.subtract(s);
        BigInteger add = sqSum.subtract(ss).divide(sub);
        int b = sub.add(add).divide(BigInteger.TWO).intValue();
        int a = BigInteger.valueOf(b).subtract(sub).intValue();
        return List.of(a, b);
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
