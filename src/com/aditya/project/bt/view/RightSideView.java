package com.aditya.project.bt.view;

import com.aditya.project.bt.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.bt.Node.initializeBinaryTree;

public class RightSideView {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        List<Integer> res = new ArrayList<>();
        func(root, 0, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static void func(Node node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(node.data);
        }
        func(node.right, level + 1, res);
        func(node.left, level + 1, res);
    }
}
