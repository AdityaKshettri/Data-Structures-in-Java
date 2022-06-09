package com.aditya.project.binarysearchtree.find;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class LCA {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        Node node = func(root, root.left, root.right);
        System.out.println(node.data);
    }

    // TC : O(logN)
    // SC : O(H)
    private static Node func(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        if (root.data > a.data && root.data > b.data) {
            return func(root.left, a, b);
        } else if (root.data < a.data && root.data < b.data) {
            return func(root.right, a, b);
        }
        return root;
    }
}
