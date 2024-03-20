package com.problems.epi.code.graphs;

import java.util.*;

public class GraphClone {

    public static class GraphVertex {
        public int label;
        public List<GraphVertex> edges;

        public GraphVertex(int label) {
            this.label = label;
            edges = new ArrayList<>();
        }
    }

    public static GraphVertex cloneGraphBFS(GraphVertex graph) {
        if (graph == null) return null;
        Deque<GraphVertex> queue = new ArrayDeque<>();
        Map<GraphVertex, GraphVertex> visited = new HashMap<>();
        queue.add(graph);
        visited.put(graph, new GraphVertex(graph.label));
        while (!queue.isEmpty()) {
            GraphVertex vertex = queue.remove();
            for (GraphVertex v : vertex.edges) {
                if (!visited.containsKey(v)) {
                    queue.add(v);
                    visited.put(v, new GraphVertex(v.label));
                }
                visited.get(vertex).edges.add(visited.get(v));
            }
        }
        return visited.get(graph);
    }

    public static GraphVertex cloneGraphDFS(GraphVertex graph, Map<GraphVertex, GraphVertex> visited) {
        visited.put(graph, new GraphVertex(graph.label));
        for (GraphVertex v : graph.edges) {
            if (!visited.containsKey(v)) {
                visited.put(v, new GraphVertex(v.label));
                cloneGraphDFS(v, visited);
            }
            visited.get(graph).edges.add(visited.get(v));
        }
        return visited.get(graph);
    }
}
