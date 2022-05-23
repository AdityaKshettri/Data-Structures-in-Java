package com.aditya.project.stack;

import java.util.Stack;

public class CheckBalancedParenthesis {

    public static void main(String[] args) {
        String a = "()[{}()]";
        if (check(a)) {
            System.out.println("All Parenthesis balanced...");
        } else {
            System.out.println("Parenthesis not balanced...");
        }
    }

    private static boolean check(String a) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();
                if (c == ')' && p == '(' || c == '}' && p == '{' || c == ']' && p == '[') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
