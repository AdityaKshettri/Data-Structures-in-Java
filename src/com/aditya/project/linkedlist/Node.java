package com.aditya.project.linkedlist;

public class Node {

    public int data;
    public Node next;
    public Node bottom;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public static Node initializeLinkedList() {
        Node root = new Node(1);
        Node head = root;
        for (int i = 2; i <= 5; i++) {
            head.next = new Node(i);
            head = head.next;
        }
        return root;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
