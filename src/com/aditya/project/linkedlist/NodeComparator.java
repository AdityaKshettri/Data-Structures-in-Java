package com.aditya.project.linkedlist;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node l1, Node l2) {
        return Integer.compare(l1.data, l2.data);
    }
}
