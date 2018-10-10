package com.problems.ctci.chapter8;

public class Question8_10 {

    public enum Color { BLACK, WHITE, YELLOW, RED, GREEN }

    public static boolean paintFill(Color[][] grid, int r, int c, Color newColor) {
        Color oldColor = grid[r][c];
        grid[r][c] = newColor;
        int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        for(int[] direction : directions) {
            int next_r = r + direction[0];
            int next_c = c + direction[1];
            if(isValidCell(grid, next_r, next_c, oldColor))
                paintFill(grid, next_r, next_c, newColor);
        }
        return true;
    }

    private static boolean isValidCell(Color[][] grid, int r, int c, Color color) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == color;
    }
}
