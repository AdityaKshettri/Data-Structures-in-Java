package com.aditya.project.binarysearchtree.find;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Count {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int[] count = new int[1];
        func(root, count);
        System.out.println(count[0]);
    }

    // TC : O(N)
    // SC : O(H)
    public static void func(Node root, int[] count) {
        if (root == null) {
            return;
        }
        func(root.left, count);
        count[0]++;
        func(root.right, count);
    }
}
