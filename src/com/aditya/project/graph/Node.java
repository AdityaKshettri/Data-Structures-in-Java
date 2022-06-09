package com.aditya.project.graph;

public class Node {
    private final int u;
    private final int v;
    private final int w;

    public Node(int v, int w) {
        this.u = 0;
        this.v = v;
        this.w = w;
    }

    public Node(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }
}
