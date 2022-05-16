package com.aditya.project.dynamic;

public class FrogJump {

    public static void main(String[] args) {
        int n = 4;
        int[] a = {10, 20, 30, 10};
        System.out.println("n = " + n);
        System.out.println("Array : ");
        print(a);
        System.out.println("Min frog jumps taking 1 or 2 steps to reach n = " + func(n, a));
    }

    private static int func(int n, int[] s) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < n; i++) {
            int fs = a + Math.abs(s[i] - s[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = b + Math.abs(s[i] - s[i - 2]);
            }
            int c = Math.min(fs, ss);
            a = b;
            b = c;
        }
        return b;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
