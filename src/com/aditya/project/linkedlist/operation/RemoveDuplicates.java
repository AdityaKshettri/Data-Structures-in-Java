package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Node head = initializeLinkedList();
        head.next.data = head.data;
        print(head);
        head = func(head);
        print(head);
    }

    // TC : O(N)
    // SC : O(N)
    private static Node func(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        Node prev = null;
        Node node = head;
        while (node != null) {
            if (set.contains(node.data)) {
                prev.next = node.next;
            } else {
                set.add(node.data);
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
