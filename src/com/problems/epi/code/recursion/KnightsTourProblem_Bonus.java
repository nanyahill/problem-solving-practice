package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.List;

/** Knights Tour Problem
 * This problem is not from EPI
 */
public class KnightsTourProblem_Bonus {

    public static List<Integer> solveKT(int[][] board) {
        //List<Integer> res = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (board == null || board.length == 0) return res;

        // This pattern of move offsets gives you the solution in the most optimized time
        // It is basically a clockwise motion of the direction choices
        int[] xmoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] ymoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

        // This random pattern of directions gives you the solution in a much longer time
        //int[] xmoves = new int[] {2, 2, -2, -2, 1, -1, 1, -1};
        //int[] ymoves = new int[] {1, -1, 1, -1, 2, 2, -2, -2};

        // Used in G4G solution, direction choices are selected in an anticlockwise motion
        //int[] xmoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        //int[] ymoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        int n = board.length;
        board[0][0] = 0;
        solveKT(0, 0, 1, xmoves, ymoves, board, n);
        return res;
    }

    private static boolean solveKT(int x, int y, int move, int[] xmoves, int[] ymoves, int[][] board, int n) {
        if (move == n * n) return true;
        //if (res1.size() == n * n) return true;
        else {
            for (int i = 0; i < n; i++) {
                int next_x = x + xmoves[i]; // col
                int next_y = y + ymoves[i]; // row
                if (isSafe(next_x, next_y, board)) {
                    board[next_x][next_y] = move;
                    //res[x][y] = move;
                    //System.out.println(move);
                    boolean ok = solveKT(next_x, next_y, move + 1, xmoves, ymoves, board, n);
                    if (ok == true) return true;
                    board[next_x][next_y] = 0;
                }
            }
            return false;
        }
    }

    private static boolean isSafe(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid[0].length) return false;
        if (y < 0 || y >= grid.length) return false;
        return grid[x][y] == 0 ? true : false;
    }

    private static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        solveKT(board);
        printBoard(board);
    }
}
