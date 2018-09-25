package com.problems.ctci.chapter1;

public class Question1_8 {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check 1st Row for zero
        for (
                int i = 0;
                i < matrix[0].length; i++)

        {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check 1st Col for zero
        for (
                int j = 0;
                j < matrix.length; j++)

        {
            if (matrix[j][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Check rest of matrix for zero
        for (
                int i = 1;
                i < matrix.length; i++)

        {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Set rows and cols of matrix to zero exept for first row and first col
        // Rows
        for (
                int i = 1;
                i < matrix.length; i++)

        {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Cols
        for (
                int i = 1;
                i < matrix[0].length; i++)

        {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstColHasZero)

        {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowHasZero)

        {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
