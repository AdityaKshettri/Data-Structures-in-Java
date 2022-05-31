package com.aditya.project.binarytree.path;

import com.aditya.project.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.project.binarytree.Node.initializeBinaryTree;

public class _RootToNodePath {

    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        int target = 7;
        System.out.println("Target : " + target);
        List<Integer> res = new ArrayList<>();
        rootToNodePath(root, target, res);
        System.out.println(res);
    }

    // TC : O(N)
    // SC : O(N)
    private static boolean rootToNodePath(Node node, int target, List<Integer> res) {
        if (node == null) {
            return false;
        }
        res.add(node.data);
        if (node.data == target) {
            return true;
        }
        if (rootToNodePath(node.left, target, res) || rootToNodePath(node.right, target, res)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
