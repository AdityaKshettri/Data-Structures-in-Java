package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

public class FlattenMultipleSorted {

    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.bottom = new Node(8);
        Node head2 = new Node(1);
        head2.bottom = new Node(7);
        head1.next = head2;
        print(head1);
        print(head2);
        Node head = flatten(head1);
        print(head);
    }

    // TC : O(No. of Nodes)
    // SC : O(1)
    private static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }

    private static Node merge(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }
        return res.bottom;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.bottom;
        }
        System.out.println();
    }
}
