package com.problems.epi.code.dynamic_programming;

public class PatternInGrid_LeetCodeWordSearch {
        public boolean exist(char[][] board, String word) {
            if(board == null) return false;
            int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            // this array is needed to ensure board entries are visited at most once.
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if(isPresent(board, i, j, word, 0, directions, visited)) return true;
                }
            }
            return false;
        }

        private boolean isPresent(char[][] board, int i, int j, String word, int idx, int[][] directions, boolean[][] visited) {
            if(idx == word.length()) return true;
            if(!isCellValid(board, i, j, word.charAt(idx))) return false;
            if(visited[i][j]) return false;
            visited[i][j] = true;
            for(int[] direction : directions) {
                if(isPresent(board, i + direction[0], j + direction[1], word, idx + 1, directions, visited)) return true;
            }
            visited[i][j] = false;
            return false;
        }

        private boolean isCellValid(char[][] board, int i, int j, char c) {
            return i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == c;
        }
}
