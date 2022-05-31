package com.aditya.project.linkedlist.find;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.print;

public class IntersectionNode {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        Node head2 = new Node(2);
        head2.next = head1.next;
        head2.next.next = new Node(6);
        print(head1);
        print(head2);
        Node intersectionNode = findIntersectionNode(head1, head2);
        System.out.println("Intersection Node : " + intersectionNode.data);
    }

    // TC : O(N+M)
    // SC : O(1)
    private static Node findIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node node1 = head1;
        Node node2 = head2;
        while (node1 != node2) {
            node1 = node1 == null ? head2 : node1.next;
            node2 = node2 == null ? head1 : node2.next;
        }
        return node1;
    }
}
