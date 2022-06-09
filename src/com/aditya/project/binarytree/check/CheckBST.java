package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckBST {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        boolean check = func(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(check ? "BST" : "Not BST");
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean func(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        boolean leftCheck = func(node.left, min, node.data);
        boolean rightCheck = func(node.right, node.data, max);
        return leftCheck && rightCheck;
    }
}
