package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensPuzzle {
    private int[][] board;
    private int n;

    public List<List<Integer>> solveNQueenPuzzle(int n) {
        initBoard(n);
        this.n = n;
        List<List<Integer>> result = new ArrayList<>();
        solve(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void initBoard(int n) {
        board = new int[n][n];
    }

    private void solve(int n, int row, List<Integer> tmp, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int col = 0; col < n; col++) {
                if (isValid(row, col)) {
                    board[row][col] = 1; // place queen
                    tmp.add(col);
                    solve(n, row + 1, tmp, result);
                    board[row][col] = 0; // remove queen
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    // In this method check if previous solved positions along the row, 45 and 135 deg diagonals.
    // Note: No need to check along the columns because that is where you are moving along from the iteration in solve(...)
    private boolean isValid(int row, int col) {
        // Check all preceding rows that have been solved
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        // Check for 135 degree diagonal: \___
        // We only want to check for upper diagonals because they have been solved already
        // start form i = row - 1 and j = col - 1 because you want to check for previous solved positions,
        // if i should start from row + 1 and j starts from col + 1 it means you are checking for positions that have not been solved yet
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check for 45 degree diagonal: /___
        // We only want to check for upper diagonals because they have been solved already
        // i decreases here because row is your position and you want to check for previous solved positions,
        // if i should increase it means you are checking for positions that have not been solved yet
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1) return false;
        return true;
    }

    public static void main(String[] args) {
        NQueensPuzzle nqp = new NQueensPuzzle();
        //List<List<Integer>> r = nqp.solveNQueenPuzzle(4);
        //System.out.print(r.size());
        System.out.println("abcd".substring(0,0).isEmpty());
    }
}
