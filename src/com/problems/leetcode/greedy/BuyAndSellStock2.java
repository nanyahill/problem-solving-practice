package com.problems.leetcode.greedy;

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

        public static void main(String[] args) {
            int[] nums = {1, 7, 2, 3, 6, 7, 6, 7};
            System.out.print(maxProfit(nums));
        }
}

