package com.aditya.project.linkedlist.check;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;

public class Cycle {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        Node node = root.next.next.next.next;
        node.next = root.next;
        System.out.println("Cyclic Linked List : " + checkIfCyclic(root));
    }

    // Tortoise Method
    // TC : O(N)
    // SC : O(1)
    private static boolean checkIfCyclic(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
