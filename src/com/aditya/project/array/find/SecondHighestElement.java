package com.aditya.project.array.find;

public class SecondHighestElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};
        print(a);
        System.out.println("Second Highest Element : " + getSecondHighest(a));
    }

    private static int getSecondHighest(int[] a) {
        int high = 0;
        int nextHigh = 0;
        for (int i : a) {
            if (i > high) {
                nextHigh = high;
                high = i;
            } else if (i > nextHigh) {
                nextHigh = i;
            }
        }
        return nextHigh;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
