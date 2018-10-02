package com.problems.ctci.chapter8;

import com.util.Cell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question8_2 {
    public static List<Cell> getPath(boolean[][] grid) {
        List<Cell> path = new ArrayList<>();
        if(grid == null || grid.length == 0) return path;
        Cell start = new Cell(0, 0);
        Cell end = new Cell(grid.length - 1, grid[0].length - 1);
        // an optimization, runtime: O(rc)
        // without optimization runtime is O(2^r+c)
        Set<Cell> failedCells = new HashSet<>();
        findPath(grid, start, end, path, failedCells);
        return path.isEmpty() ? null : path;
    }

    private static boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path, Set<Cell> failedCells) {
        if(!isValidPoint(grid, start)) return false;
        if(failedCells.contains(start)) return false;
        path.add(start);
        if(start.row == end.row && start.row == end.col) return true;
        int[][] directions = { {0, 1}, {1, 0} };
        for(int[] direction : directions) {
            Cell next = new Cell(start.row + direction[0], start.col + direction[1]);
            if (findPath(grid, next, end, path, failedCells)) return true;
        }
        failedCells.add(path.get(path.size() - 1));
        path.remove(path.size() - 1);
        return false;
    }

    private static boolean isValidPoint(boolean[][] grid, Cell cell) {
        return cell.row >= 0 && cell.row < grid.length && cell.col >= 0 && cell.col < grid[cell.row].length && grid[cell.row][cell.col];
    }
}
