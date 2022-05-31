package com.aditya.project.linkedlist.operation;

import com.aditya.project.linkedlist.Node;

import static com.aditya.project.linkedlist.Node.initializeLinkedList;
import static com.aditya.project.linkedlist.Node.print;

public class DeleteGivenNode {

    public static void main(String[] args) {
        Node root = initializeLinkedList();
        print(root);
        deleteGivenNode(root.next.next);
        print(root);
    }

    // Dumb Solution
    // TC : O(1)
    // SC : O(1)
    private static void deleteGivenNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
