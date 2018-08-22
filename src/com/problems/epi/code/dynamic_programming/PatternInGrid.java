package com.problems.epi.code.dynamic_programming;

public class PatternInGrid {

    public static boolean isPatternInGrid(int[][] grid, int[]pattern) {
        if(grid == null || pattern == null) return false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(isPatternInGrid(grid, pattern,i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean isPatternInGrid(int[][] grid, int[] pattern, int i, int j, int pos) {
        if(pattern.length == pos) return true;
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != (pattern[pos])) { return false; }
        if(isPatternInGrid(grid, pattern, i - 1, j, pos + 1) || // check down
                isPatternInGrid(grid, pattern, i + 1, j, pos + 1) || // check up
                isPatternInGrid(grid, pattern, i, j - 1, pos + 1) || // check left
                isPatternInGrid(grid, pattern, i, j + 1, pos + 1)) // check right
                { return true; }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[] {7, 5, 1};
        grid[1] = new int[] {8, 3, 1};
        grid[2] = new int[] {3, 6, 4};
        //Arrays.asList(grid);
        int[] pattern = new int[] {1, 3, 4, 6};
        System.out.print(isPatternInGrid(grid, pattern));

    }
}
