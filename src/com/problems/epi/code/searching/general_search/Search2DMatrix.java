package com.problems.epi.code.searching.general_search;

import java.util.List;

public class Search2DMatrix {

        public static boolean matrixSearchNotEfficient(List<List<Integer>> grid, int k) {
            if(grid == null || grid.isEmpty()) return false;
            for(int i = 0; i < grid.size(); i++) {
                int min = grid.get(i).get(0);
                int max = grid.get(i).get(grid.get(i).size() - 1);
                if(k >= min && k <= max) {
                    for(int j = 0; j < grid.get(i).size(); j++) {
                        if(grid.get(i).get(j) == k) return true;
                    }
                }
            }
            return false;
        }

    public static boolean matrixSearchEfficient(List<List<Integer>> grid, int k) {
        if(grid == null || grid.isEmpty()) return false;
        int row = 0;
        int col = grid.get(0).size() - 1;
        while(row < grid.size() && col >= 0) {
            if(grid.get(row).get(col) == k) return true;
            else if(grid.get(row).get(col) < k) row++;
            else col--;
        }
        return false;
    }
}
