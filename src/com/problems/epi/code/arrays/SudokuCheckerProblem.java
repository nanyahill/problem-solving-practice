package com.problems.epi.code.arrays;


import java.util.List;

public class SudokuCheckerProblem {

    public static boolean isValidSudoku(List<List<Integer>> grid) {
        int rowSize = grid.size();
        int colSize = grid.get(0).size();

        for(int i = 0; i < rowSize; i++) {
            if(hasDuplicates(grid, i, i + 1, 0, colSize)) return false;
        }

        for(int i = 0; i < colSize; i++) {
            if(hasDuplicates(grid, 0, rowSize, i, i + 1)) return false;
        }

        int regionSize = (int) Math.sqrt(rowSize);
        for(int i = 0; i < regionSize; i++) {
            for(int j = 0; j < regionSize; j++) {
                if(hasDuplicates(grid, i * regionSize, (i + 1) * regionSize, j * regionSize, (j + 1) * regionSize)) return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicates(List<List<Integer>> grid, int startRow, int endRow, int startCol, int endCol) {
        boolean[] isPresent = new boolean[10];
        for(int i = startRow; i < endRow; i++) {
            for(int j = startCol; j < endCol; j++) {
                int digit = grid.get(i).get(j);
                if(digit != 0) {
                    if(isPresent[digit]) {
                        return true;
                    }
                    isPresent[digit] = true;
                }
            }
        }
        return false;
    }
}
