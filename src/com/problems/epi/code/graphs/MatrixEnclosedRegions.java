package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Similar to Leetcode 130: Surrounded Regions
 */
public class MatrixEnclosedRegions {

    public static void fillSurroundedRegions(List<List<Character>> board) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Mark first and last row and surrounding regions
        for(int i = 0; i < board.get(0).size(); i++) {
            // First Row
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
            if(board.get(j).get(board.get(0).size() - 1) == 'W')
                markRegions_DFS(board, j, board.get(0).size() - 1, directions);
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
                board.get(curr.i).set(curr.j, 'T');
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
