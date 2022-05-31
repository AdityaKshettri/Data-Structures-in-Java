package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.print;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);
        print(head1);
        print(head2);
        print(add2Numbers(head1, head2));
    }

    // TC : O(N)
    // SC : O(N)
    private static Node add2Numbers(Node head1, Node head2) {
        Node dummy = new Node();
        Node temp = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry == 1) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }
}
