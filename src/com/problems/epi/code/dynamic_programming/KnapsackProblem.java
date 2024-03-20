package com.problems.epi.code.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Key Insight: The thief can take an item or not take an item
 * Not taking an item means: They will move (i.e. recurse) on to the next item with the wgt of knapsack unchanged
 * Pseudocode: recurse(nextItem, wgt knapsack)
 * Taking an item means: They will take that item (subtract the item's wgt from knapsack's capacity)
 * and move (i.e. recurse) on to next item. Pseudocode: item.wgt > wgt knapsack ? 0 : recurse(nextItem, wgt - item.wgt)
 * Max Profit = Math.max(not taking an item, taking an item)
 *
 * In the cache array- row is usually the item (an object with fields wgt and value) and col is the knapsack weight
 */
public class KnapsackProblem {

    public static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int weight) {
        if(items == null || items.isEmpty()) return -1;
        int[][] table = new int[items.size() + 1][weight + 1];
        for(int[] row : table) Arrays.fill(row, - 1);
        //return recursive(items, items.size(), weight);
        return topDown(items, items.size(), weight, table);
    }

    private static int recursive(List<Item> items, int i, int j) {
        if(i == 0) return 0;
        if(j == 0) return 0;
        Item item = items.get(i - 1);
        int withItem = item.weight <= j ? recursive(items, i - 1, j - item.weight) + item.value : 0;
        int withoutItem = recursive(items, i - 1, j);
        return Math.max(withItem, withoutItem);
    }

    private static int topDown(List<Item> items, int i, int j, int[][] table){
        if(i == 0) return 0;
        if(j == 0) return 0;
        if(table[i][j] == -1) {
            Item item = items.get(i - 1);
            int withItem = item.weight <= j ? topDown(items, i - 1, j - item.weight, table) + item.value : 0;
            int withoutItem = topDown(items, i - 1, j, table);
            table[i][j] = Math.max(withItem, withoutItem);
        }
        return table[i][j];
    }

    public static int bootomUp2D(List<Item> items, int weight) {
        if(items == null || items.isEmpty()) return -1;
        int[][] table = new int[items.size() + 1][weight + 1];
        for(int i = 1; i <= items.size(); i++) {
            Item item = items.get(i - 1);
            for(int j = 1; j <= weight; j++) {
                int withItem = item.weight <= j ? table[i - 1][j - item.weight] + item.value : 0;
                int withoutItem = table[i - 1][j];
                table[i][j] = Math.max(withItem, withoutItem);
            }
        }
        return table[items.size()][weight];
    }

    public static int findMaximumProfit_BottomUpDP_WithMinSpace(List<Item> items, int weight) {
        if(items == null || items.isEmpty()) return -1;
        int[] table = new int [weight + 1];
        for(int i = 1; i <= items.size(); i++) {
            Item item = items.get(i - 1);
            /**
             * why does going from 0 to w fails?
             * It is because if we go from 0 to w we lose the [j-w[i]] value of the previous row.
             * Going from 0 to w prematurely modifies that value.
             */
            for(int j = weight; j >= item.weight; j--) {
                int withItem = table[j - item.weight] + item.value;
                int withoutItem = table[j];
                table[j] = Math.max(withItem, withoutItem);
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
