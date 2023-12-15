package com.problems.epi.code.dynamic_programming;

/**
 * Similar to Robot in Grid WITHOUT obstacles
 * Key Insight: For any pos (i, j), look back and ask- how did I get here: either from above cell (i - 1 , j)
 * or from left cell (i, j - 1). That is, either I take one path (take above cell) or I don't (take left cell).
 * Then recurse on those cells.
 * Unique Paths I in Leetcode
 */
public class CountPathsInMatrix {

    public static int countPaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] grid = new int[m][n];
        //int m = grid.length - 1;
        //int n = grid[0].length - 1;
        return countPaths_TopDownDP(grid, m - 1, n - 1);
        //return countPaths_Recursive(m - 1, n - 1); // m - 1 and n - 1 are important.
        //return countPaths_BottomUpDP(grid, m - 1, n - 1);
    }

    private static int countPaths_Recursive(int m, int n) {
        if (m == 0 || n == 0) return 1;
        // if (m < 0 || n < 0) return 0;
        return countPaths_Recursive(m, n - 1) + countPaths_Recursive(m - 1, n);
    }

    // Note: No need to worry about check if outside of grid since it will not happen because of the base case
    private static int countPaths_TopDownDP(int[][] grid, int i, int j) {
        if (i == 0 || j == 0) return 1;
        if (grid[i][j] == 0)
            grid[i][j] = countPaths_TopDownDP(grid, i, j - 1) + countPaths_TopDownDP(grid, i - 1, j);
        return grid[i][j];
    }

    private static int countPaths_BottomUpDP(int[][] grid, int n, int m) {
        // preprocess grid- initialize 1st row and 1st column
        initGrid(grid, n, m);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[n - 1][m - 1];
    }

    private static void initGrid(int[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) grid[i][0] = 1; // rows
        for (int j = 0; j < m; j++) grid[0][j] = 1; // columns
    }

    /**
     * Time: O(nm)
     * Space: O(min(n,m)
     */
    public static int countPaths_BottomUp_WithMinSpace(int n, int m) {
        if (n == 0 || m == 0) return 0;
        int maxDim = Math.max(n, m);
        int minDim = Math.min(n, m);
        int[] cache = new int[minDim];
        cache[0] = 1;
        for (int i = 0; i < maxDim; i++) {
            for (int j = 0; j < minDim; j++) {
                if (j > 0) {
                    cache[j] += cache[j - 1];
                }
            }
        }
        return cache[cache.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPaths(2, 3));
    }
}
