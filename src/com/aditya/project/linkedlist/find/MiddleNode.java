package com.aditya.project.linkedlist.find;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class MiddleNode {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        System.out.println("Middle node : " + findMiddleNode(root).data);
    }

    // Tortoise Method
    // TC : O(N)
    // SC : O(1)
    private static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
