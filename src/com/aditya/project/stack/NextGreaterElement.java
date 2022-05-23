package com.aditya.project.stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] a = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        System.out.println("Array :");
        print(a);
        a = calculateNextGreaterElement(a);
        System.out.println("Next Greater Element :");
        print(a);
    }

    private static int[] calculateNextGreaterElement(int[] a) {
        int n = a.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            } else {
                nge[i] = -1;
            }
            stack.push(a[i]);
        }
        return nge;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
