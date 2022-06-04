package com.aditya.project.bst;

import static com.aditya.project.bst.Node.initializeBinarySearchTree;

public class Search {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int target = 8;
        System.out.println(search(root, target) != null ? "Found" : "Not Found");
    }

    private static Node search(Node root, int target) {
        while (root != null && root.data != target) {
            root = target < root.data ? root.left : root.right;
        }
        return root;
    }
}
