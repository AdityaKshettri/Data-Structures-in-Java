package com.aditya.project.binarytree;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public static Node initializeBinaryTree() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        left = new Node(4);
        right = new Node(5);
        root.left.left = left;
        root.left.right = right;
        left = new Node(6);
        right = new Node(7);
        root.right.left = left;
        root.right.right = right;
        return root;
    }
}
