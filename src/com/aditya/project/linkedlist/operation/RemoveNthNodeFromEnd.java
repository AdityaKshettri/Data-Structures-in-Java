package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import java.util.Objects;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        int n = 3;
        System.out.println("N = " + n);
        Node head = removeNthNodeFromEnd(root, n);
        print(head);
    }

    // TC : O(N)
    // SC : O(1)
    private static Node removeNthNodeFromEnd(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start;
        Node slow = start;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = Objects.requireNonNull(slow.next).next;
        return head;
    }
}
