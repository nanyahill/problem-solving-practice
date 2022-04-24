package com.problems.epi.code.graphs;

import java.util.*;

public class SearchMaze {

    private static class Cell {
        int i;
        int j;
        
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public enum Color { BLACK, WHITE }

    public static List<Cell> findPathInMaze(List<List<Color>> maze, Cell start, Cell end) {
    List<Cell> path = new ArrayList<>();
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    if(!searchMaze_DFS(maze, start, end, directions, path)) return Collections.emptyList();
    return path;
    }

    private static boolean searchMaze_DFS(List<List<Color>> maze, Cell curr, Cell end, int[][]directions, List<Cell> result) {
        if(!isFeasible(curr, maze)) return false; // check if cell is still in the maze and cell is unvisited
        maze.get(curr.i).set(curr.j, Color.BLACK); // mark cell as visited
        result.add(curr); // add cell to result
        if(curr.i == end.i && curr.j == end.j) return true;
        for(int[] direction : directions) {// for all possible directions
            int next_x = curr.i + direction[0];
            int next_y = curr.j + direction[1];
            if(searchMaze_DFS(maze, new Cell(next_x, next_y), end, directions, result) == true) return true;
        }
        result.remove(result.size() - 1); // remove cell from result since it did not work
        return false;
    }

    private static boolean searchMazeHelper_BFS(List<List<Color>> maze, Cell start, Cell end, List<Cell> result, int[][] directions) {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offerLast(start);
        while(!queue.isEmpty()) {
            Cell cell = queue.removeFirst();
            result.add(new Cell(cell.i, cell.j));
            if(cell.i == end.i && cell.j == end.j) return true;
            for(int[] direction : directions) {
                int next_x = cell.i + direction[0];
                int next_y = cell.j + direction[1];
                Cell nextCell = new Cell(next_x, next_y);
                if(!isFeasible(nextCell, maze)) continue;
                maze.get(nextCell.i).set(nextCell.j, Color.BLACK);
                queue.push(nextCell);
            }
        }
        return false;
    }

    private static boolean isFeasible(Cell curr, List<List<Color>> maze) {
        return curr.i >= 0 && curr.i < maze.size() && curr.j >= 0 && curr.j < maze.get(curr.i).size() && maze.get(curr.i).get(curr.j) == Color.WHITE;
    }

}
