package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * This problem is similar to the flood fill algorithm
 * Key Insight: What is a connected region? A region where all cells that have the same color as the starting vertex and can be reached
 * from the starting vertex.
 * https://leetcode.com/problems/flood-fill/description/
 * In Leetcode, there is an input pixel as well as an input color. There is an optimisation where
 * if the inputColor != pixelColor that is when you solve; otherwise return the image
 */
public class MatrixConnectedRegions {

    public static void findConnectedRegions_DFS(List<List<Boolean>> grid, int x, int y) {
        if(grid == null || grid.isEmpty()) return;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        dfs(grid, x, y, grid.get(x).get(y), directions);
    }

    private static void dfs(List<List<Boolean>> grid, int x, int y, boolean value, int[][] directions){
        if(isCellValid(grid, x, y, value)) {
            grid.get(x).set(y, !value);
            for(int[] direction : directions) {
                dfs(grid, x + direction[0], y + direction[1], value, directions);
            }
        }
    }

    private static boolean isCellValid(List<List<Boolean>> grid, int x, int y, boolean value) {
        return x >= 0 && x < grid.size() && y >= 0 && y < grid.get(x).size() && grid.get(x).get(y) == value;
    }

    private static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void findConnectedRegions_BFS(int x, int y, List<List<Boolean>> grid) {
        if(grid == null || grid.isEmpty()) return;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        boolean value = grid.get(x).get(y);
        Deque<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(x, y));
        while(!queue.isEmpty()) {
            Coordinate cell = queue.remove();
            grid.get(cell.x).set(cell.y, !value);
            for(int[] direction : directions) {
                if(isCellValid(grid, cell.x + direction[0], cell.y + direction[1], value)) {
                    queue.add(new Coordinate(cell.x + direction[0], cell.y + direction[1]));
                }
            }
        }
    }
}
