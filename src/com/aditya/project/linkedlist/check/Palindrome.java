package com.aditya.project.linkedlist.check;

import com.aditya.project.linkedlist.Node;

public class Palindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        System.out.println("Palindrome Linked List : " + isPalindrome(head));
    }

    // TC : O(N)
    // SC : O(1)
    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMiddleNode(head);
        mid.next = reverse(mid.next);
        Node temp = mid.next;
        while (temp != null) {
            if (head.data != temp.data) {
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        return true;
    }

    // Tortoise Method
    // TC : O(N)
    // SC : O(1)
    private static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
