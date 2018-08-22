package com.problems.classic_dynamic_programming;

import java.util.List;

public class CountCoinChangeCombination {

    /******************* Recursion Approach (Non-DP) **************************
     **************************************************************************/
    private static int countScoreCombinations_Recursive(List<Integer> coins, int change, int index) {
        if(index < 0) return 0;
        if(change == 0) return 1;
        if(change < 0) return 0;
        return countScoreCombinations_Recursive(coins, change - coins.get(index), index) // with play
                + countScoreCombinations_Recursive(coins, change, index - 1); // without play
    }

    /******************* Top Down DP Approach **************************
     *******************************************************************/
    public static int countScoreCombinations_TopDown(int change, List<Integer> coins) {
        if(coins == null || coins.size() == 0) return 1;
        int[][] cache = new int[coins.size()][change + 1];
        return countScoreCombinations_TopDown(coins, coins.size() - 1, change, cache); // moving from right to left in coins list
    }

    private static int countScoreCombinations_TopDown(List<Integer> coins, int i, int j, int[][] cache) {
        if(i < 0) return 0;
        if(j == 0) return 1;
        if(j < 0) return 0;
        int withthisPlay = countScoreCombinations_TopDown(coins, i, j - coins.get(i), cache);
        int withoutPlay = countScoreCombinations_TopDown(coins, i - 1, j, cache);
        cache[i][j] = withoutPlay + withthisPlay;
        return cache[i][j];
    }

    /******************* Bottom Up DP Approach **************************
     *******************************************************************/
    // Time Complexity: O(sn) where s = size of coins list and n = change
    // Space complexity: O(n)
    public static int countScoreCombinations_BottomUp(List<Integer> coins, int change) {
        if(coins == null || coins.size() == 0) return 1;
        int[] scoreBoard = new int[change + 1];
        scoreBoard[0] = 1;
        for (int i = 0; i < coins.size(); i++) {
            int code = coins.get(i); // minor optimization
            for (int j = code; j <= change; j++) {
                //int play = coins.get(i);
                //if (j < play) continue;
                int withThisPlay = scoreBoard[j - code];
                int withoutThisPlay = scoreBoard[j];
                scoreBoard[j] = withoutThisPlay + withThisPlay;
            }
        }
        return scoreBoard[change];
    }
}