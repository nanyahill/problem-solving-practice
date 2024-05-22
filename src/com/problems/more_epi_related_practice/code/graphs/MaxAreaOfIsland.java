package com.problems.more_epi_related_practice.code.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int result = dfs(grid, i, j, directions);
                    maxArea = Math.max(maxArea, result);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int[][] directions) {
        if (!isCellValid(grid, i, j)) return 0;
        grid[i][j] = 0;
        int result = 1;
        for (int[] direction : directions) {
            int nexti = i + direction[0];
            int nextj = j + direction[1];
            result += dfs(grid, nexti, nextj, directions);
        }
        return result;
    }

    private int bfs(int[][] grid, int i, int j, int[][] directions) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 0;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] coord = queue.remove();
            i = coord[0];
            j = coord[1];
            for (int[] direction : directions) {
                int nexti = i + direction[0];
                int nextj = j + direction[1];
                if (isCellValid(grid, nexti, nextj)) {
                    result++;
                    queue.add(new int[]{nexti, nextj});
                    grid[nexti][nextj] = 0;
                }
            }
        }
        return result;
    }

    private boolean isCellValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1;
    }
}
