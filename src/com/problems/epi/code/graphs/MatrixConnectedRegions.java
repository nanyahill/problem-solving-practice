package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * This problem is similar to the flood fill algorithm
 */
public class MatrixConnectedRegions {

    public static void findConnectedRegions_DFS(List<List<Boolean>> grid, int x, int y) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean color = grid.get(x).get(y);
        grid.get(x).set(y, !color);
        for(int[] direction : directions) {
            int next_x = x + direction[0];
            int next_y = y + direction[1];
            if(isValidXY(grid, next_x, next_y, color)) findConnectedRegions_DFS(grid, next_x, next_y);
        }
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
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean color = grid.get(x).get(y);
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(x,y));
        grid.get(x).set(y, !color);
        while(!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for(int[] direction : directions) {
                Coordinate next = new Coordinate(curr.x + direction[0], curr.y + direction[1]);
                if(isValidXY(grid, next.x, next.y, color)) {
                    queue.add(next);
                    grid.get(next.x).set(next.y, !color);
                }
            }
        }
    }

    private static boolean isValidXY(List<List<Boolean>> grid, int x, int y, boolean color) {
        return x >= 0 && x < grid.size() && y >= 0 && y < grid.get(x).size() && grid.get(x).get(y) == color;
    }
}
