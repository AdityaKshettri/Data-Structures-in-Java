package com.aditya.project.binarysearchtree.operation;

import com.aditya.project.binarysearchtree.Node;

import static com.aditya.project.binarysearchtree.Node.initializeBinarySearchTree;

public class Delete {

    public static void main(String[] args) {
        Node root = initializeBinarySearchTree();
        int target = 5;
        root = delete(root, target);
        System.out.println(root.data);
    }

    // TC : O(logN)
    // SC : O(1)
    private static Node delete(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return helper(root);
        }
        Node node = root;
        while (node != null) {
            if (node.data > target) {
                if (node.left != null && node.left.data == target) {
                    node.left = helper(node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right != null && node.right.data == target) {
                    node.right = helper(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    private static Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node lastRight = findLastRight(root.left);
            lastRight.right = root.right;
            return root.left;
        }
    }

    private static Node findLastRight(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
