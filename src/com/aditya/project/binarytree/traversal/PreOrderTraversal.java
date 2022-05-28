package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class PreOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static void preOrderTraversal(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.data);
        preOrderTraversal(node.left, res);
        preOrderTraversal(node.right, res);
    }
}
