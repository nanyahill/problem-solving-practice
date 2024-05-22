package com.problems.more_epi_related_practice.code.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int numIslands = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, directions);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void bfs(char[][] grid, int i, int j, int[][] directions) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] coord = queue.remove();
            for (int[] direction : directions) {
                int nexti = coord[0] + direction[0];
                int nextj = coord[1] + direction[1];
                if (isCellValid(grid, nexti, nextj)) {
                    queue.add(new int[]{nexti, nextj});
                    grid[nexti][nextj] = '0';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j, int[][] directions) {
        if (isCellValid(grid, i, j)) {
            grid[i][j] = '0';
            for (int[] direction : directions) {
                dfs(grid, direction[0] + i, direction[1] + j, directions);
            }
        }
    }

    private boolean isCellValid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1';
    }
}
