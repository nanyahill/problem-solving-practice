package com.problems.epi.test.playful;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    private static int[] coins = new int[]{1, 2, 3};

    public static int makeChange(int c) {
        if (c == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
// Try removing each coin from the total and
// see how many more coins are required
        for (int coin : coins) {
// Skip a coin if it’s value is greater
// than the amount remaining
            if (c - coin >= 0) {
                int currMinCoins = makeChange(c - coin);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
// Add back the coin removed recursively
        return minCoins + 1;
    }

    public static int makeChange_BackTracking(int c, List<Integer> tmp) {
        if (c == 0) {
            for (Integer a : tmp) {
                System.out.print(a + ", ");
            }
            System.out.println();
            return 0;
        }
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (c - coin >= 0) {
                tmp.add(coin);
                int currMinCoins = makeChange_BackTracking(c - coin, tmp);
                if (currMinCoins + 1 < minCoins)
                    minCoins = currMinCoins + 1;
                tmp.remove(tmp.size() - 1);
            }
        }
        return minCoins;
    }

    public static void main(String[] args) {

        makeChange_BackTracking(10, new ArrayList<>());
    }
}
