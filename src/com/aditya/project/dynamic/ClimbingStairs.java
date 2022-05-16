package com.aditya.project.dynamic;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        System.out.println("Total no. of ways taking 1 or 2 steps to reach n = " + func(n));
    }

    private static int func(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
