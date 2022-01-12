package com.aditya.project.prog;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {

        System.out.println();

        int a = 12, b = 15;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("HCF = " + hcf(a, b));
        System.out.println("LCM = " + lcm(a, b));

        System.out.println();

        int c = 1234;
        System.out.println("c = " + c);
        System.out.println("Number of digits = " + countDigits(c));

        System.out.println();

        int d = 1031;
        System.out.println("d = " + d);
        System.out.println("Is Prime = " + isPrime(d));

        System.out.println();

        int e = 126;
        System.out.println("e = " + e);
        System.out.println("Prime factors :");
        primeFactors(e);

        System.out.println();

        int f = 26;
        System.out.println("f = " + f);
        System.out.println("Divisors :");
        divisors(f);

        System.out.println();

        int g = 10;
        System.out.println("g = " + g);
        System.out.println("All Prime no. till n :");
        sieveOfEratosthenes(g);

        System.out.println();

        int h = 3, i = 5;
        System.out.println("h = " + h);
        System.out.println("i = " + i);
        System.out.println("Power : " + power(h, i));

        System.out.println();

        int j = 42;
        System.out.println("j = " + j);
        System.out.println("Number of digits in factorial = " + digitsInFactorial(j));

        long k = 9223372036854775807L;
        long l = 9223372036854775807L;
        long m = 1000000007;
        System.out.println("k = " + k);
        System.out.println("l = " + l);
        System.out.println("modulo m = " + m);
        System.out.println("Sum under modulo : " + sumUnderModulo(k, l, m));
    }

    // O(log(min(a,b))
    public static int hcf(int a, int b) {
        if (b == 0) {
            return a;
        }
        return hcf(b, a % b);
    }

    // O(log(min(a,b))
    public static int lcm(int a, int b) {
        return a * b / hcf(a, b);
    }

    // O(1)
    public static int countDigits(int n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

    // O(root(n))
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // O(root(n))
    public static void primeFactors(int n) {
        while (n % 2 == 0) {
            System.out.println(2);
            n = n / 2;
        }
        while (n % 3 == 0) {
            System.out.println(3);
            n = n / 3;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            while (n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                System.out.println(i + 2);
                n = n / (i + 2);
            }
        }
        if (n > 3) {
            System.out.println(n);
        }
    }

    // O(root(n))
    public static void divisors(int n) {
        int i;
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                System.out.println(n / i);
            }
        }
    }

    // O(n * log(log n))
    // To find all prime number till n
    public static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[i] = false;
                }
            }
        }
    }

    // O(log n)
    public static long power(int x, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }

    // O(n)
    public static int digitsInFactorial(int N) {
        double l = 0;
        for (int i = 2; i <= N; i++) {
            l = l + Math.log10(i);
        }
        return (int) Math.floor(l) + 1;
    }

    // O(1)
    public static long sumUnderModulo(long a, long b, long m) {
        return ((a % m) + (b % m)) % m;
    }
}
