package com.aditya.project.binarysearchtree.operation;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Insert {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int target = 10;
        root = insert(root, target);
        System.out.println(root.right.right.right.data);
    }

    // TC : O(logN)
    // SC : O(1)
    private static Node insert(Node root, int target) {
        if (root == null) {
            return new Node(target);
        }
        Node curr = root;
        while (true) {
            if (curr.data <= target) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new Node(target);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new Node(target);
                    break;
                }
            }
        }
        return root;
    }
}
