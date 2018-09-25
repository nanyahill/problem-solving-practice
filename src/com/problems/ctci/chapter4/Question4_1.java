package com.problems.ctci.chapter4;

import com.util.Graph;
import com.util.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question4_1 {

    public static boolean doesPathExist_DFS(Graph graph, GraphNode start, GraphNode end) {
        if(start == end) return true;
        start.visited = true;
        for(GraphNode child : start.children) {
            if(!child.visited) {
                if(doesPathExist_DFS(graph, child, end)) return true;
            }
        }
        return false;
    }

    public static boolean doesPathExist_BFS(Graph graph, GraphNode start, GraphNode end) {
        if(start == null || end == null) return false;
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.addLast(start);
        GraphNode n;
        while(!queue.isEmpty()) {
            n = queue.removeFirst();
            if(n == end) return true;
            n.visited = true;
            for(GraphNode child : n.children) {
                if(!child.visited) {
                    queue.addLast(child);
                }
            }
        }
        return false;
    }
}
