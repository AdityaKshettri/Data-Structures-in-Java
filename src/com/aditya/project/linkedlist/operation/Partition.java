package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.print;

public class Partition {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(50);
        print(head);
        int x = 3;
        head = func(head, x);
        print(head);
    }

    // TC : O(N)
    // SC : O(1)
    private static Node func(Node head, int x) {
        Node smallHead = null;
        Node smallLast = null;
        Node equalHead = null;
        Node equalLast = null;
        Node bigLast = null;
        Node bigHead = null;
        while (head != null) {
            if (head.data == x) {
                if (equalHead == null) {
                    equalHead = equalLast = head;
                } else {
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            } else if (head.data < x) {
                if (smallHead == null) {
                    smallHead = smallLast = head;
                } else {
                    smallLast.next = head;
                    smallLast = smallLast.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = bigLast = head;
                } else {
                    bigLast.next = head;
                    bigLast = bigLast.next;
                }
            }
            head = head.next;
        }
        if (bigLast != null) {
            bigLast.next = null;
        }
        if (smallHead == null) {
            if (equalHead == null) {
                return bigHead;
            }
            equalLast.next = bigHead;
            return equalHead;
        }
        if (equalHead == null) {
            smallLast.next = bigHead;
            return smallHead;
        }
        smallLast.next = equalHead;
        equalLast.next = bigHead;
        return smallHead;
    }
}
