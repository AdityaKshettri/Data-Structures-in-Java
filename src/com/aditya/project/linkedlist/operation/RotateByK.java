package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class RotateByK {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        int k = 2;
        root = rotate(root, k);
        print(root);
    }

    // TC : O(N)
    // SC : O(1)
    private static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = 1;
        Node curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }
        curr.next = head;
        k = k % n;
        k = n - k;
        while (k-- > 0) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
