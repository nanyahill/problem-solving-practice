package com.problems.epi.code.arrays;


public class BuyAndSellStock_I {

    public static int computeProfit2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    profit = Math.max(profit, prices[j] - prices[i]);
                }
            }
        }
        return profit;
    }

    public static int computeProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int costPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - costPrice);
            costPrice = Math.min(costPrice, prices[i]);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] values = {7, 1, 5, 3, 6, 4, 8};
        System.out.print(computeProfit(values));
    }
}
