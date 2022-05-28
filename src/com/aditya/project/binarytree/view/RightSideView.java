package com.aditya.project.binarytree.view;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class RightSideView {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        rightSideView(root, 0, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static void rightSideView(Node node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(node.data);
        }
        rightSideView(node.right, level + 1, res);
        rightSideView(node.left, level + 1, res);
    }
}
