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

// ****************** TIME SINK: THIS IS NOT THE CORRECT SOLUTION ******************************* //
    // I SHOULD DELETE IT BUT LEFT IT HERE AS A DEMO OF WHAT A BFS SOLUTION FOR THIS PROBLEM SHOULD NOT BE.
    // FYI- This solution does not pass any test case in EPI- fails with error: contains invalid segments
    // Reason- In the end, the result contains all coordinates for each level order traversal so we need a solution
    // that can trace the path in a BFS (level order) traversal
//    private static boolean searchMazeHelper_BFS(List<List<Color>> maze, Cell start, Cell end, List<Cell> result, int[][] directions) {
//        Deque<Cell> queue = new ArrayDeque<>();
//        queue.offerLast(start);
//        while(!queue.isEmpty()) {
//            Cell cell = queue.removeFirst();
//            result.add(new Cell(cell.i, cell.j));
//            if(cell.i == end.i && cell.j == end.j) return true;
//            for(int[] direction : directions) {
//                int next_x = cell.i + direction[0];
//                int next_y = cell.j + direction[1];
//                Cell nextCell = new Cell(next_x, next_y);
//                if(!isFeasible(nextCell, maze)) continue;
//                maze.get(nextCell.i).set(nextCell.j, Color.BLACK);
//                queue.push(nextCell);
//            }
//        }
//        return false;
//    }

    // ******************************** THIS IS THE CORRECT SOLUTION THAT WORKS IN EPI (just change Cell to Coordinate) ******************************* //
    // Another approach would be maintaining a mapping from each node to its parent, and when inspecting the adjacent
    // node, record its parent. When the search is done, simply backtrace according the parent mapping.
    // https://stackoverflow.com/questions/8922060/how-to-trace-the-path-in-a-breadth-first-search
    private static List<Cell> searchMazeBFS_ReturnPath(List<List<Color>> maze, Cell start, Cell end, List<Cell> result, int[][] directions) {
        Deque<List<Cell>> queue = new ArrayDeque<>();
        queue.offerLast(new ArrayList<>(Arrays.asList(start)));
        while (!queue.isEmpty()) {
            List<Cell> path = queue.removeFirst();
            Cell cell = path.get(path.size() - 1);
            maze.get(cell.i).set(cell.j, Color.BLACK);
            if (cell.i == end.i && cell.j == end.j) {
                return path;
            }
            for (int[] direction : directions) {
                int next_x = cell.i + direction[0];
                int next_y = cell.j + direction[1];
                Cell nextCell = new Cell(next_x, next_y);
                if (!isFeasible(nextCell,maze)) continue;
                List<Cell> newPath = new ArrayList<>(path);
                newPath.add(nextCell);
                queue.push(newPath);
            }
        }
        return Collections.emptyList();
    }

    private static boolean isFeasible(Cell curr, List<List<Color>> maze) {
        return curr.i >= 0 && curr.i < maze.size() && curr.j >= 0 && curr.j < maze.get(curr.i).size() && maze.get(curr.i).get(curr.j) == Color.WHITE;
    }
}
