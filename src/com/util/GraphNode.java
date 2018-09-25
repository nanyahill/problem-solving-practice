package com.util;

public class GraphNode {

    public boolean visited;
    public GraphNode[] children;
    int size = 0;

    public GraphNode() {}

    public void addChild(GraphNode node) {
        children[size++] = node;
    }
}
