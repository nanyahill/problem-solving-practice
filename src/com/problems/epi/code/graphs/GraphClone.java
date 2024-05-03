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

    public static GraphVertex cloneGraph(GraphVertex graph) {
        if(graph == null) return null;
        Map<GraphVertex, GraphVertex> map = new HashMap<>();
        cloneGraph(graph, map);
        return map.get(graph);
    }

    private static void cloneGraph(GraphVertex vertex, Map<GraphVertex, GraphVertex> visited) {
        visited.put(vertex, new GraphVertex(vertex.label));
        for(GraphVertex v : vertex.edges) {
            if(!visited.containsKey(v)) {
                cloneGraph(v, visited);
            }
            visited.get(vertex).edges.add(v);
        }
    }

    public static GraphVertex cloneGraphBFS(GraphVertex graph) {
        if (graph == null) return null;
        // Step 1: Create a Queue
        Deque<GraphVertex> queue = new ArrayDeque<>();
        // Step 2: Create a Set to track visisted nodes
        Map<GraphVertex, GraphVertex> visited = new HashMap<>();
        // Step 3: Add initial node to queue to start with
        queue.add(graph);
        // Step 4: Iteratively process each element in queue until empty
        while (!queue.isEmpty()) {
            // Step 5: Extract element from Queue to process
            GraphVertex vertex = queue.remove();
            // Step 6: Do something with current node here BEFORE finding neighbors
            // Step 6.1: Mark current node as visisted if needed
            visited.put(vertex, new GraphVertex(vertex.label));
            // Step 7: Queue neighboring nodes to process later
            for (GraphVertex v : vertex.edges) {
                if (!visited.containsKey(v)) {
                    queue.add(v);
                }
                // Step 8: Do something with current node here AFTER finding neighbors
                // Step 8.1: Mark current node as visisted if needed
                visited.get(vertex).edges.add(v);
            }
        }
        return visited.get(graph);
    }
}
