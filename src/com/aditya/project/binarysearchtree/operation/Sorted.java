package com.aditya.project.binarysearchtree.operation;

import com.aditya.project.binarysearchtree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Sorted {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        List<Integer> res = new ArrayList<>();
        func(root, res);
        System.out.println(res);
    }

    // Inorder Traversal
    // TC : O(N)
    // SC : O(N)
    private static void func(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        func(root.left, res);
        res.add(root.data);
        func(root.right, res);
    }
}
