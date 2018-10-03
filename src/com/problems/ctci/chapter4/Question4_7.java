package com.problems.ctci.chapter4;

import java.util.*;

public class Question4_7 {

    public static List<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return findBuildOrder(graph.getNodes());
    }

    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    private static List<Project> findBuildOrder(List<Project> projects) {
        Deque<Project> stack = new ArrayDeque<>();
        for(Project project : projects) {
            if(project.getState() == Project.State.BLANK) {
                if(!doDFS(stack, project)) return null;
            }
        }
        List<Project> result = new ArrayList<>();
        while(!stack.isEmpty()) result.add(stack.pollLast());
        return result;
    }

    private static boolean doDFS(Deque<Project> stack, Project p) {
        if(p.getState() == Project.State.PARTIAL) return false;
        if(p.getState() == Project.State.BLANK) {
            p.state = Project.State.PARTIAL;
            List<Project> children = p.getChildren();
            for(Project child : children) {
                if(!doDFS(stack, child)) return false;
            }
            p.state = Project.State.COMPLETE;
            stack.offerLast(p);
        }
        return true;
    }

    public static class Project {
        public enum State {COMPLETE, PARTIAL, BLANK}
        private List<Project> children = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();
        private String name;
        private State state = State.BLANK;

        public Project(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
            }
        }

        public State getState() {
            return state;
        }

        public void setState(State st) {
            state = st;
        }

        public List<Project> getChildren() {
            return children;
        }
    }

    public static class Graph {
        private List<Project> nodes = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public List<Project> getNodes() {
            return nodes;
        }
    }
}
