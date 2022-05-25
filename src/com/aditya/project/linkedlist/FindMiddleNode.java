package com.aditya.project.linkedlist;

public class FindMiddleNode {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        System.out.println("Middle node : " + findMiddleNode(root).data);
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
    private static Node findMiddleNode(Node head) {
        Node fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
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
