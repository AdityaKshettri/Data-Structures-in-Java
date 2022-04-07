package com.aditya.project.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Tower of Hanoi for n : " + n);
        towerOfHanoi(n, 'A', 'B', 'C');
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
}
