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



    /**** 10/11/2024: Trying to understand how coin change works without the need for a loop *******/
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] table = new int[amount + 1];
        Arrays.fill(table, -1);
        table[0] = 0;
        int result = recursive(coins, coins.length, amount, table);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int recursive(int[] coins, int i, int amount, int[] table) {
        if (amount == 0)
            return 0;
        if (i == 0 || amount < 0)
            return Integer.MAX_VALUE;
        if (table[amount] != -1)
            return table[amount];
        //int notTake = recursive(coins, i - 1, amount, table);
        int coin = coins[i - 1];
        int take = Integer.MAX_VALUE;
        if (amount >= coin) {
            int result = recursive(coins, i, amount - coin, table);
            if (result != Integer.MAX_VALUE) {
                take = result + 1;
            }
        }
        int notTake = recursive(coins, i - 1, amount, table);
        System.out.println("i :" + i + " Take: " + take + " NotTake: " + notTake + " Amount: " + amount);
        table[amount] = Math.min(take, notTake);
        return table[amount];
    }

    public static void main(String args[]) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);

    }
}
