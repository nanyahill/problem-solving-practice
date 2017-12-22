package com.problems.epi.code.chapter5;

/**
 * Created by Nanya on 12/20/17.
 */
public class SudokuCheckerProblem {

    public static boolean isValidSudoku(int[][] sudoku) {
        if(sudoku == null || sudoku.length == 0) return false;

        int rows = sudoku.length;
        int cols = sudoku[0].length;

        // Check row constraints
        for(int i = 0; i < rows; i++) {
            if(hasDuplicates(sudoku, i, i + 1, 0, cols)) {
                return false;
            }
        }

        // Check column constraints
        for(int i = 0; i < cols; i++) {
            if(hasDuplicates(sudoku, 0, rows, i, i + 1)) {
                return false;
            }
        }

        // Check region constraints
        int regionSize = (int) Math.sqrt(sudoku.length);
        for(int i = 0; i < regionSize; i++) {
            for(int j = 0; j < regionSize; j++) {
                if(hasDuplicates(sudoku, i * regionSize, (i+1) * regionSize, j * regionSize, (j+1) * regionSize)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasDuplicates(int[][] sudoku, int row_start, int row_end, int col_start, int col_end) {
        boolean[] isPresent = new boolean[sudoku.length + 1];
        for(int i = row_start; i < row_end; i++) {
            for(int j = col_start; j < col_end; j++) {
                if(sudoku[i][j] != 0 && isPresent[sudoku[i][j]] == true) {
                    return true;
                }
                isPresent[sudoku[i][j]] = true;
            }
        }
        return false;
    }
}
