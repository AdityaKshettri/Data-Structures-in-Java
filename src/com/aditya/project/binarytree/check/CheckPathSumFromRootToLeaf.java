package com.aditya.project.binarytree.check;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class CheckPathSumFromRootToLeaf {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int target = 7;
        System.out.println("Has Path Sum from Root To Leaf : " + func(root, target));
    }

    private static boolean func(Node node, int target) {
        if (node == null) {
            return false;
        }
        if (node.data == target && node.left == null && node.right == null) {
            return true;
        }
        return func(node.left, target - node.data) || func(node.right, target - node.data);
    }
}
