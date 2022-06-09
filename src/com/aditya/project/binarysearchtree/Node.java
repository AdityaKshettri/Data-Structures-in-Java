package com.aditya.project.binarysearchtree;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public static Node initializeBinarySearchTree() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        return root;
    }
}
