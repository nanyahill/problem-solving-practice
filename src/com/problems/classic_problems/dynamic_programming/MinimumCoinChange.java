package com.problems.classic_problems.dynamic_programming;

import java.util.Arrays;

public class MinimumCoinChange {

    /******************* Recursive Non-DP Approach **************************
     *******************************************************************/
    public int coinChange_Recursive(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int num = coinChange_Recursive(coins, amount - coins[i]);
            if (num >= 0) min = Math.min(num + 1, min);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /******************* Top Down DP Approach **************************
     *******************************************************************/
    public static int coinChange_TopDown(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        return coinChange_TopDown(coins, amount, cache);
    }

    private static int coinChange_TopDown(int[] coins, int c, int[] cache) {
        if (c == 0) return 0;
        if (c < 0) return -1;
        if (cache[c] != Integer.MAX_VALUE) return cache[c];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int num = coinChange_TopDown(coins, c - coins[i], cache);
            if (num >= 0) min = Math.min(num + 1, min);
        }
        cache[c] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[c];
    }

    /******************* Bottom Up DP Approach **************************
     *******************************************************************/
    public int coinChange_BottomUp(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (j >= coin && cache[j - coin] != Integer.MAX_VALUE)
                    cache[j] = Math.min(cache[j], cache[j - coin] + 1);
            }
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}
