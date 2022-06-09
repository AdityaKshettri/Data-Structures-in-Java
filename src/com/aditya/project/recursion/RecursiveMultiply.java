package com.aditya.project.recursion;

// Multiply 2 no. without using *
// Minimize those operations
public class RecursiveMultiply {

    public static void main(String[] args) {
        int a = 17;
        int b = 23;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a * b = " + func(a, b));
    }

    // TC : O(log a)
    // SC : O(log a) for Recursion
    private static int func(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        int s = a / 2;
        int halfProd = func(s, b);
        if (a % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + b;
        }
    }
}
