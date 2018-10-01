package com.problems.epi.code.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

    public static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int findMaximumProfit_Recursive(List<Item> items, int weight) {
        if(items == null || items.size() == 0) return 0;
        return findMaximumProfit_Recursive(items, items.size() - 1, weight);
    }

    private static int findMaximumProfit_Recursive(List<Item> items, int i, int w) {
        if(i == 0) return 0;
        if(w == 0) return 0;
        return Math.max(findMaximumProfit_Recursive(items, i - 1, w), items.get(i).weight > w ? 0 : items.get(i).value + findMaximumProfit_Recursive(items, i - 1, w - items.get(i).weight));
    }

    public static int findMaximumProfit_TopDownDP(List<Item> items, int weight) {
        if (items == null || items.size() == 0) return 0;
        int[][] table = new int[items.size() + 1][weight + 1];
        for(int[] row : table)Arrays.fill(row, -1);
        return findMaximumProfit_TopDownDP(items, items.size(), weight, table);
    }

    private static int findMaximumProfit_TopDownDP(List<Item> items, int i, int j, int[][] table) {
        if (i == 0 || j == 0) return 0;
        //if (j == 0) return 0;
        if (table[i][j] == -1) {
            table[i][j] = Math.max(findMaximumProfit_TopDownDP(items, i - 1, j, table), items.get(i-1).weight > j ? 0 : items.get(i-1).value + findMaximumProfit_TopDownDP(items, i - 1, j - items.get(i-1).weight, table));
        }
        return table[i][j];
    }

    public static int findMaximumProfit_BottomUpDP(List<Item> items, int weight) {
        if(items == null || items.size() == 0) return 0;
        int[][] table = new int[items.size() + 1][weight + 1];
        //Arrays.fill(table[0], 0);
        for(int i = 1; i <=items.size(); i++) {
            int itemWeight = items.get(i-1).weight;
            int itemValue = items.get(i-1).value;
            // this order of inner for loop iteration is important,
            // because you start with an almost full knapsack that has a
            // remaining weight of j and you try to see what item can fill up that remaining weight
            for(int j = 0; j <= weight; j++) {
                if(itemWeight > j) table[i][j] = table[i-1][j];
                else table[i][j] = Math.max(table[i-1][j], itemValue + table[i-1][j - itemWeight]);
            }
        }
        return table[items.size()][weight];
    }

    public static int findMaximumProfit_BottomUpDP_WithMinSpace(List<Item> items, int weight) {
        if(items == null || items.size() == 0) return 0;
        int[] table = new int [weight + 1];
        for(int i = 1; i <= items.size(); i++) {
            int itemWeight = items.get(i-1).weight;
            int itemValue = items.get(i-1).value;
            // this order of inner for loop iteration is important,
            // because an empty knapsack has a weight = wgt and you try to fill it up.
            for(int j = weight; j >= itemWeight; j--) {
                table[j] = Math.max(table[j], itemValue + table[j - itemWeight]);
            }
        }
        return table[weight];
    }

    public static void main(String[] args) {
        int[][] items = {{6, 10}, {1, 3}, {4, 2}, {3, 6}, {2,4}};
        //[49, 12], [97, 18], [80, 46], [18, 33], [55, 4], [11, 34], [55, 72], [11, 100], [4, 84], [78, 75], [52, 96], [36, 35], [25, 60], [100, 94], [57, 87], [85, 62], [27, 72], [35, 39], [85, 82], [10, 16], [13, 13], [13, 50], [50, 43], [19, 100], [41, 26], [38, 39], [37, 73], [98, 24], [17, 26], [98, 97], [22, 14], [85, 93], [87, 59], [7, 81], [13, 54], [39, 80], [17, 86], [95, 80], [3, 17], [90, 76], [29, 2], [5, 91], [14, 59], [85, 12], [38, 50], [28, 94], [94, 84], [99, 50], [39, 86], [95, 46], [32, 2], [31, 38], [95, 64], [22, 16], [27, 9], [9, 25], [38, 95], [26, 83], [83, 8], [18, 100], [3, 31], [92, 64], [46, 47], [9, 84], [99, 39], [23, 1], [44, 87], [41, 41], [50, 35], [89, 33], [30, 87], [74, 56], [13, 55], [70, 12], [75, 100], [82, 55], [36, 34], [4, 34], [79, 59], [100, 90], [85, 11], [18, 52], [69, 3], [72, 1], [3, 72], [11, 59], [34, 5], [36, 2], [7, 34], [10, 40], [69, 34], [2, 34], [49, 52], [67, 79], [99, 33], [35, 80], [69, 10], [96, 85], [86, 97], [44, 21], [37, 56], [16, 46], [63, 36], [87, 2], [21, 69], [34, 32], [8, 15], [50, 61], [100, 69], [37, 11], [66, 98], [54, 43], [33, 35], [53, 86], [17, 33], [84, 28], [6, 34], [93, 40], [31, 20], [66, 43], [61, 3], [2, 63], [76, 31], [7, 66], [92, 13], [54, 10], [57, 16], [44, 93], [87, 55], [84, 28], [6, 19], [76, 46], [16, 75], [35, 70], [51, 34], [15, 12], [26, 6], [64, 45], [35, 73], [46, 46], [41, 2], [32, 87], [41, 6], [62, 24], [47, 16], [27, 74], [61, 100]];
        int weight = 5;
        List<Item> itemsList = new ArrayList<>();
        for(int i = 0; i < items.length; i++) {
            itemsList.add(new Item(items[i][0], items[i][1]));
        }
        System.out.print(findMaximumProfit_BottomUpDP_WithMinSpace(itemsList, 10));

    }
}
