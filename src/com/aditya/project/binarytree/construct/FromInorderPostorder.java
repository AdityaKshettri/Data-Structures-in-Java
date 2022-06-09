package com.aditya.project.binarytree.construct;

import com.aditya.project.binarytree.Node;

import java.util.HashMap;
import java.util.Map;

public class FromInorderPostorder {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        Node node = func(inorder, postOrder);
        System.out.println(node.data);
    }

    private static Node func(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        int m = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return func(inorder, 0, n - 1, postorder, 0, m - 1, map);
    }

    private static Node func(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        Node root = new Node(postorder[postEnd]);
        int index = map.get(root.data);
        int numsLeft = index - inStart;
        root.left = func(inorder, inStart, index - 1, postorder, postStart, postStart + numsLeft - 1, map);
        root.right = func(inorder, index + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);
        return root;
    }
}
