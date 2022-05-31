package com.aditya.project.binarytree.calculation;

import com.aditya.project.binarytree.Node;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        Node lca = findLowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println(lca.data);
    }

    // TC : O(N)
    // SC : O(N)
    private static Node findLowestCommonAncestor(Node node, Node a, Node b) {
        if (node == null || node == a || node == b) {
            return node;
        }
        Node left = findLowestCommonAncestor(node.left, a, b);
        Node right = findLowestCommonAncestor(node.right, a, b);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return node;
    }
}
