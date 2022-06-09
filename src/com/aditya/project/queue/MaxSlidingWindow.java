package com.aditya.project.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] a = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;
        System.out.println("Max Sliding Window (Brute Force) :");
        print(funcBruteForce(a, k));
        System.out.println("Max Sliding Window (Deque) :");
        print(funcDeque(a, k));
    }

    // TC : O(N*K)
    // SC : O(K)
    private static int[] funcBruteForce(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = 0;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, a[j]);
            }
            r[i] = max;
        }
        return r;
    }

    // TC : O(N)
    // SC : O(K)
    private static int[] funcDeque(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (!dq.isEmpty() && i >= k - 1) {
                r[j++] = a[dq.peek()];
            }
        }
        return r;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
