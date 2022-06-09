package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.print;

public class MergeTwoSorted {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        print(head1);
        print(head2);
        print(mergeTwoSortedLinkedList(head1, head2));
    }

    // TC : O(N+M)
    // SC : O(1)
    private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data > head2.data) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        Node res = head1;
        while (head2 != null) {
            Node curr = head1;
            while (head1 != null && head1.data <= head2.data) {
                curr = head1;
                head1 = head1.next;
            }
            curr.next = head2;
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        return res;
    }
}
