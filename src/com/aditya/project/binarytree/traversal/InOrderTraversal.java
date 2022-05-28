package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class InOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static void inOrderTraversal(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, res);
        res.add(node.data);
        inOrderTraversal(node.right, res);
    }
}
