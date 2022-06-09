package com.aditya.project.linkedlist.find;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;

public class StartingPointOfCycle {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        Node node = root.next.next.next.next;
        node.next = root.next;
        Node start = findStartingPointOfCycle(root);
        System.out.println("Starting Point of Cycle : " + start.data);
    }

    // Tortoise Method Extension
    // TC : O(N)
    // SC : O(1)
    private static Node findStartingPointOfCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}
