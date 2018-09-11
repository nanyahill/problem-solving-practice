package com.problems.classic_problems.dynamic_programming;

import java.util.List;

public class CountCoinChangeCombination {

    /******************* Recursion Approach (Non-DP) **************************
     **************************************************************************/
    private static int countCoinChange_Recursive(List<Integer> coins, int change, int index) {
        if(index < 0) return 0;
        if(change == 0) return 1;
        if(change < 0) return 0;
        return countCoinChange_Recursive(coins, change - coins.get(index), index) // with play
                + countCoinChange_Recursive(coins, change, index - 1); // without play
    }

    /******************* Top Down DP Approach **************************
     *******************************************************************/
    public static int countCoinChange_TopDown(int change, List<Integer> coins) {
        if(coins == null || coins.size() == 0) return 1;
        int[][] cache = new int[coins.size()][change + 1];
        return countCoinChange_TopDown(coins, coins.size() - 1, change, cache); // moving from right to left in coins list
    }

    private static int countCoinChange_TopDown(List<Integer> coins, int i, int j, int[][] cache) {
        if(i < 0) return 0;
        if(j == 0) return 1;
        if(j < 0) return 0;
        int withthisPlay = countCoinChange_TopDown(coins, i, j - coins.get(i), cache);
        int withoutPlay = countCoinChange_TopDown(coins, i - 1, j, cache);
        cache[i][j] = withoutPlay + withthisPlay;
        return cache[i][j];
    }

    /******************* Bottom Up DP Approach **************************
     *******************************************************************/
    // Time Complexity: O(sn) where s = size of coins list and n = change
    // Space complexity: O(n)
    public static int countCoinChange_BottomUp(List<Integer> coins, int change) {
        int[] cache = new int[change + 1];
        cache[0] = 1;
        for (int i = 0; i < coins.size(); i++) {
            //int code = coins.get(i); // minor optimization
            for (int j = 1; j <= change; j++) {
                int changeLeft = j - coins.get(i);
                if (changeLeft >= 0) {
                    int withThisCoin = cache[changeLeft];
                    int withoutThisCoin = cache[j];
                    cache[j] = withoutThisCoin + withThisCoin;
                }
            }
        }
        return cache[change];
    }
}