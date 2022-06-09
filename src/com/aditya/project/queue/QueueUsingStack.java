package com.aditya.project.queue;

import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }

    private static class Queue {

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        Queue() {
        }

        void push(int x) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            input.push(x);
            while (!output.isEmpty()) {
                input.push(output.pop());
            }
        }

        int pop() {
            if (input.isEmpty()) {
                System.out.println("Stack is Empty!");
            }
            return input.pop();
        }

        int peek() {
            if (input.isEmpty()) {
                System.out.println("Stack is Empty!");
            }
            return input.peek();
        }

        int size() {
            return input.size();
        }
    }
}
