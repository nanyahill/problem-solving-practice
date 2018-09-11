package com.problems.leetcode.code.greedy;

/*
 * Leetcode #122
 */
public class BuyAndSellStock2 {

        public static int maxProfit(int[] prices) {
            int maxprofit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    int valley = prices[i-1];
                    int peak = prices[i];
                    maxprofit += peak - valley;
                }
            }
            return maxprofit;
        }
}

