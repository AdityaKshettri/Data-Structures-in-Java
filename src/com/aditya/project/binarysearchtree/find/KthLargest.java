package com.aditya.project.binarysearchtree.find;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class KthLargest {

    static Node node;

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int k = 2;
        int[] count = new int[1];
        func(root, count, k);
        System.out.println(node.data);
    }

    // TC : O(N)
    // SC : O(H)
    public static void func(Node root, int[] count, int k) {
        if (root == null) {
            return;
        }
        func(root.right, count, k);
        count[0]++;
        if (count[0] == k) {
            node = root;
        }
        func(root.left, count, k);
    }
}
