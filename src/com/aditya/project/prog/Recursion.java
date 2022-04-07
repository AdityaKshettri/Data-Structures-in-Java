package com.aditya.project.prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {

        System.out.println();

        int n = 17;
        System.out.println("n = " + n);
        System.out.println("floor(log2n) = " + getLogNBase2(n));

        System.out.println();

        n = 7;
        System.out.println("Binary to decimal of n = " + n);
        convertDecimalToBinary(n);

        System.out.println();

        String s = "ababa";
        System.out.println("s = " + s);
        System.out.println("isPalindrome = " + isPalindrome(s, 0, s.length() - 1));

        System.out.println();

        n = 127;
        System.out.println("n = " + n);
        System.out.println("sum of digits = " + sumOfDigits(n));

        System.out.println();

        n = 23;
        int a = 12, b = 11, c = 9;
        System.out.println("n = " + n);
        System.out.println("max number of peices = " + maxPieces(n, a, b, c));

        System.out.println();

        s = "abc";
        System.out.println("Subsets for string s : " + s);
        generateSubsets(s, "", 0);

        System.out.println();

        n = 3;
        System.out.println("Tower of Hanoi for n : " + n);
        towerOfHanoi(n, 'A', 'B', 'C');

        System.out.println();

        n = 5;
        int k = 3;
        System.out.println("n : " + n);
        System.out.println("k : " + k);
        System.out.println("Josephus Problem : " + josephusProblem(n, k));

        System.out.println();

        n = 3;
        int[] arr = new int[]{10, 20, 15};
        int sum = 25;
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("sum : " + sum);
        System.out.println("No. of subsets with given sum : " + countSubsetsWithSum(arr, n, sum));

        System.out.println();

        n = 3;
        arr = new int[]{3, 1, 2};
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("Array Subsets :");
        printAllSubsets(0, new ArrayList<>(), arr);

        System.out.println();

        n = 3;
        arr = new int[]{1, 2, 1};
        sum = 2;
        System.out.println("n : " + n);
        System.out.print("Array : ");
        Arrays.stream(arr).forEach(value -> System.out.print(value + "\t"));
        System.out.println();
        System.out.println("sum : " + sum);
        System.out.println("Subsets with given sum : ");
        printSubsetsWithSum(0, new ArrayList<>(), 0, sum, arr);
    }

    // floor(log2n)
    private static int getLogNBase2(int n) {
        if (n == 1)
            return 0;
        return 1 + getLogNBase2(n / 2);
    }

    // O(n)
    private static void convertDecimalToBinary(int n) {
        if (n == 0)
            return;
        convertDecimalToBinary(n / 2);
        System.out.print(n % 2);
    }

    // O(n)
    private static boolean isPalindrome(String a, int start, int end) {
        if (start >= end)
            return true;
        return a.charAt(start) == a.charAt(end)
                && isPalindrome(a, start + 1, end - 1);
    }

    // O(number of digits in n)
    private static int sumOfDigits(int n) {
        if (n <= 9)
            return n;
        return sumOfDigits(n / 10) + n % 10;
    }

    // max pieces of n using a, b, c
    // O(3^n)
    private static int maxPieces(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int res = Math.max(
                Math.max(maxPieces(n - a, a, b, c),
                        maxPieces(n - b, a, b, c)),
                maxPieces(n - c, a, b, c));
        if (res == -1)
            return -1;
        return res + 1;
    }

    // Generate Subsets
    private static void generateSubsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.print(curr + "\t");
            return;
        }
        generateSubsets(s, curr, i + 1);
        generateSubsets(s, curr + s.charAt(i), i + 1);
    }

    // Tower of Hanoi
    // 2^n - 1 steps
    // A B C
    // Source Intermediate Destination
    private static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move 1 from " + a + " to " + c);
            return;
        }
        towerOfHanoi(n - 1, a, c, b);
        System.out.println("Move " + n + " from " + a + " to " + c);
        towerOfHanoi(n - 1, b, a, c);
    }

    // Josephus Problem (indexes start from 0)
    // Given n people, kill every kth person in a circle
    // Given the index of survivor
    // O(n)
    private static int josephusProblem(int n, int k) {
        if (n == 1)
            return 0;
        return (josephusProblem(n - 1, k) + k) % n;
    }

    // Count Subset SUM problem
    // O(2^n)
    private static int countSubsetsWithSum(int[] a, int n, int sum) {
        if (n == 0)
            return (sum == 0) ? 1 : 0;
        return countSubsetsWithSum(a, n - 1, sum) + countSubsetsWithSum(a, n - 1, sum - a[n - 1]);
    }

    // Subsequence Problem
    // O(n) Aux Space
    // O(2^n)
    private static void printAllSubsets(int i, List<Integer> curr, int[] a) {
        if (i >= a.length) {
            System.out.println(curr);
            return;
        }
        curr.add(a[i]);
        printAllSubsets(i + 1, curr, a);
        curr.remove((Integer) a[i]);
        printAllSubsets(i + 1, curr, a);
    }

    // Subsequence SUM Problem
    // O(n) Aux Space
    // O(2^n)
    private static void printSubsetsWithSum(int i, List<Integer> curr, int s, int sum, int[] a) {
        if (i >= a.length) {
            if (s == sum) {
                System.out.println(curr);
            }
            return;
        }
        curr.add(a[i]);
        s += a[i];
        printSubsetsWithSum(i + 1, curr, s, sum, a);
        curr.remove((Integer) a[i]);
        s -= a[i];
        printSubsetsWithSum(i + 1, curr, s, sum, a);
    }

    // Combination SUM Problem - repetition allowed
    // O(n) Aux Space
    // O(2^n)
    private static void printCombinationForSum(int i, List<Integer> curr, int s, int sum, int[] a) {
        if (i >= a.length) {
            if (s == sum) {
                System.out.println(curr);
            }
            return;
        }
        curr.add(a[i]);
        s += a[i];
        printSubsetsWithSum(i + 1, curr, s, sum, a);
        curr.remove((Integer) a[i]);
        s -= a[i];
        printSubsetsWithSum(i + 1, curr, s, sum, a);
    }

    // Subsequence SUM Problem - Only 1
    // O(n) Aux Space
    // O(2^n)
    private static boolean printOnlyOneSubsetWithSum(int i, List<Integer> curr, int s, int sum, int[] a) {
        if (i >= a.length) {
            if (s == sum) {
                System.out.println(curr);
                return true;
            }
            return false;
        }
        curr.add(a[i]);
        s += a[i];
        if (printOnlyOneSubsetWithSum(i + 1, curr, s, sum, a)) {
            return true;
        }
        curr.remove((Integer) a[i]);
        s -= a[i];
        if (printOnlyOneSubsetWithSum(i + 1, curr, s, sum, a)) {
            return true;
        }
        return false;
    }
}
