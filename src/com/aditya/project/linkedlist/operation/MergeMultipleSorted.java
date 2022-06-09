package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;
import com.aditya.project.linkedlist.NodeComparator;

import java.util.PriorityQueue;

public class MergeMultipleSorted {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        Node l3 = new Node(2);
        l3.next = new Node(6);
        Node[] a = {l1, l2, l3};
        Node root = func(a);
        while (root != null) {
            System.out.println(root.data + " ");
            root = root.next;
        }
    }

    // TC : O(NlogN)
    // SC : O(N)
    private static Node func(Node[] a) {
        PriorityQueue<Node> pq = new PriorityQueue<>(10, new NodeComparator());
        for (Node root : a) {
            while (root != null) {
                pq.add(root);
                root = root.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        Node head = pq.poll();
        Node node = head;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
