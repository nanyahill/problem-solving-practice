package com.problems.ctci.chapter1;

public class Question1_8 {

    public static void setZeroes(int[][] grid) {
        if(grid == null || grid.length == 0) return;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Iterate over all entries
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    if(i == 0) firstRowHasZero = true;
                    if(j == 0) firstColHasZero = true;
                    grid[i][0] = 0;
                    grid[0][j] = 0;
                }
            }
        }

        // Nullify cols
        for(int i = 1; i < grid[0].length; i++) {
            if(grid[0][i] == 0) nullifyCol(grid, i);
        }

        // Nullify rows
        for(int j = 1; j < grid.length; j++) {
            if(grid[j][0] == 0) nullifyRow(grid, j);
        }

        if(firstRowHasZero) nullifyRow(grid, 0);
        if(firstColHasZero) nullifyCol(grid, 0);
    }

    private static void nullifyRow(int[][] grid, int row) {
        for(int i = 0; i < grid[row].length; i++) {
            grid[row][i] = 0;
        }
    }

    private static void nullifyCol(int[][] grid, int col) {
        for(int i = 0; i < grid.length; i++) {
            grid[i][col] = 0;
        }
    }
}
