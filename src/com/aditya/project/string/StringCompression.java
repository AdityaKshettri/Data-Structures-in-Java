package com.aditya.project.string;

public class StringCompression {

    public static void main(String[] args) {
        char[] a = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd', 'd'};
        int n = compress(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
    }

    // TC : O(N)
    // SC : O(1)
    public static int compress(char[] a) {
        int n = a.length;
        if (n <= 1) {
            return n;
        }
        int i = 0;
        int j = 0;
        while (i < n) {
            int count = 0;
            char c = a[i];
            while (i < n && a[i] == c) {
                count++;
                i++;
            }
            a[j++] = c;
            if (count > 1) {
                for (char p : Integer.toString(count).toCharArray()) {
                    a[j++] = p;
                }
            }
        }
        return j;
    }
}
