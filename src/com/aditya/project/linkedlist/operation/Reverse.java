package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class Reverse {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        root = reverse(root);
        print(root);
    }

    // TC : O(N)
    // SC : O(1)
    private static Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
