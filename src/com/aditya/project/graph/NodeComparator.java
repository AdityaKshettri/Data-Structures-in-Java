package com.aditya.project.graph;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.getW(), node2.getW());
    }
}
