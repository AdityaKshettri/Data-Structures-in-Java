package com.aditya.project.binarytree.traversal;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class PostOrderTraversal {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        System.out.println(res);
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
