package com.aditya.project.linkedlist;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        int n = 3;
        System.out.println("N = " + n);
        Node head = removeNthNodeFromEnd(root, n);
        print(head);
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
        slow.next = slow.next.next;
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
