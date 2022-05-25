package com.aditya.project.linkedlist;

public class Reverse {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        root = reverse(root);
        print(root);
    }

    private static Node initializeLinkedList() {
        Node root = new Node(1);
        Node head = root;
        for (int i = 2; i <= 5; i++) {
            head.next = new Node(i);
            head = head.next;
        }
        return root;
    }

    // TC : O(N)
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

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
