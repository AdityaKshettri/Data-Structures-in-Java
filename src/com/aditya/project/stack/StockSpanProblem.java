package com.aditya.project.stack;

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] span = func(prices);
        for (int i : span) {
            System.out.print(i + " ");
        }
    }

    // TC : O(N)
    // SC : O(N)
    private static int[] func(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] s = new int[n];
        stack.push(0);
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                s[i] = i + 1;
            } else {
                s[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return s;
    }
}
