package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Node head = initializeLinkedList();
        System.out.println("Given Linked List :");
        print(head);
        System.out.println("After Swapping (Recursion) :");
        head = funcRecursion(head);
        print(head);
        head = initializeLinkedList();
        System.out.println("After Swapping (Space Optimized) :");
        head = func(head);
        print(head);
    }

    // Recursion
    // TC : O(N)
    // SC : O(N)
    private static Node funcRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;
        Node second = head.next;
        first.next = funcRecursion(second.next);
        second.next = first;
        return second;
    }

    // Space Optimized
    // TC : O(N)
    // SC : O(1)
    private static Node func(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node start = new Node();
        start.next = head;
        Node prev = start;
        while (head != null && head.next != null) {
            Node first = head;
            Node second = head.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            head = first.next;
        }
        return start.next;
    }
}
