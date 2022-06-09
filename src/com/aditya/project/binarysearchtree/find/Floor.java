package com.aditya.project.binarysearchtree.find;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Floor {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int key = 4;
        System.out.println(func(root, key));
    }

    // TC : O(logN)
    // SC : O(1)
    private static int func(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data < key) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
