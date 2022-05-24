package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        System.out.println(res);
    }

    private static Node initializeBinaryTree() {
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

    // TC : O(N)
    // SC : O(N)
    private static void postOrderTraversal(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, res);
        postOrderTraversal(node.right, res);
        res.add(node.data);
    }
}
