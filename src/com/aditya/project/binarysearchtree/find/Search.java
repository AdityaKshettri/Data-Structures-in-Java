package com.aditya.project.binarysearchtree.find;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Search {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int target = 8;
        System.out.println(search(root, target) != null ? "Found" : "Not Found");
    }

    // TC : O(logN)
    // SC : O(1)
    private static Node search(Node root, int target) {
        while (root != null && root.data != target) {
            root = target < root.data ? root.left : root.right;
        }
        return root;
    }
}
