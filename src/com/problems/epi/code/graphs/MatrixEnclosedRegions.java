package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Similar to Leetcode 130: Surrounded Regions
 *   /**
 *    * Key Insights:
 *    * Focus on the inverse of the problem- identify all Ws that can reach the boundary by starting with the
 *    * initial set of Ws AT the boundary.
 *    * This way we find Ws neighbouring the boundary Ws and iteratively grow the set.
 *    * Time complexity: O(mn) where m and n are the number of rows and cols in grid
 *    * @param board
 *    */

public class MatrixEnclosedRegions {

    public static void fillSurroundedRegions(List<List<Character>> board) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Mark first and last row and surrounding regions
        for(int i = 0; i < board.get(0).size(); i++) {
            // First row``
            if(board.get(0).get(i) == 'W')
                markRegions_DFS(board, 0, i, directions);
            // Last Row
            if(board.get(board.size() - 1).get(i) == 'W')
                markRegions_DFS(board, board.size() - 1, i, directions);
        }

        // Mark first and last column and surrounding regions
        for(int j = 0; j < board.size(); j++) {
            // First Column
            if(board.get(j).get(0) == 'W')
                markRegions_DFS(board, j, 0, directions);
            if(board.get(j).get(board.get(j).size() - 1) == 'W')
                markRegions_DFS(board, j, board.get(j).size() - 1, directions);
        }

        // Fill surrounded regions
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.get(i).size(); j++) {
                board.get(i).set(j, board.get(i).get(j) == 'T' ? 'W' : 'B');
            }
        }
    }

    private static class Cell {
        public int i;
        public int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void markRegions_BFS(List<List<Character>> board, int i, int j, int[][] directions) {
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(i, j));
        while(!queue.isEmpty()) {
            Cell curr = queue.poll();
            if(curr.i >= 0 && curr.i < board.size() && curr.j >= 0 && curr.j < board.get(curr.i).size() && board.get(curr.i).get(curr.j) == 'W') {
                // Note: the below line can also appear after removing from queue.
                board.get(curr.i).set(curr.j, 'T');
                // Below for loop can be changed to four cell additions to the queue
                for(int[] direction : directions) {
                    queue.add(new Cell(curr.i + direction[0], curr.j + direction[1]));
                }
            }
        }
    }

    private static void markRegions_DFS(List<List<Character>> board, int i, int j, int[][] directions) {
        if (i >= 0 && i < board.size() && j >= 0 && j < board.get(i).size() && board.get(i).get(j) == 'W') {
            board.get(i).set(j, 'T');
            for (int[] direction : directions) {
                markRegions_DFS(board, i + direction[0], j + direction[1], directions);
            }
        }
    }
}
