package com.problems.epi.code.recursion;

import java.util.Arrays;

public class SudokuSolver {

    public static boolean solveSudoku(int[][] grid) {
        if (grid == null || grid.length == 0) return false;
        return solveSudoku(0, 0, grid.length, grid);
    }

    private static boolean solveSudoku(int row, int col, int n, int[][] grid) {
        if (col == grid[row].length) {
            col = 0;
            row = row + 1;
            if (row == n) return true; // no more cells to solve
        }
        // skip already solved cells
        if (grid[row][col] != 0) return solveSudoku(row, col + 1, n, grid);
        for (int i = 1; i <= 9; i++) { // all possible choices
            if (isValidToInsert(row, col, grid, i)) {
                grid[row][col] = i;
                if (solveSudoku(row, col + 1, n, grid) == true) return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValidToInsert(int row, int col, int[][] grid, int val) {
        //check row
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == val) return false;
        }

        // check column
        for (int j = 0; j < grid.length; j++) {
            if (grid[row][j] == val) return false;
        }

        // check subgrid
        int startRow = row - (row % 3);
        //int endRow = row + (row % 3);
        int startCol = col - (col % 3);
        //int endCol = col + (col % 3);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r + startRow][c + startCol] == val) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[9][9];
        grid[0] = new int[]{5, 3, 0, 0, 7, 0, 0, 0, 0};
        grid[1] = new int[]{6, 0, 0, 1, 9, 5, 0, 0, 0};
        grid[2] = new int[]{0, 9, 8, 0, 0, 0, 0, 6, 0};

        grid[3] = new int[]{8, 0, 0, 0, 6, 0, 0, 0, 3};
        grid[4] = new int[]{4, 0, 0, 8, 0, 3, 0, 0, 1};
        grid[5] = new int[]{7, 0, 0, 0, 2, 0, 0, 0, 6};

        grid[6] = new int[]{0, 6, 0, 0, 0, 0, 2, 8, 0};
        grid[7] = new int[]{0, 0, 0, 4, 1, 9, 0, 0, 5};
        grid[8] = new int[]{0, 0, 0, 0, 8, 0, 0, 7, 9};

        System.out.println(solveSudoku(grid));
        for (int i = 0; i < 9; i++)
            System.out.println(Arrays.toString(grid[i]));

    }
}
