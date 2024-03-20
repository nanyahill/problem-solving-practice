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
        if(prices == null || prices.length == 0) return 0;
        int costPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - costPrice);
            costPrice = Math.min(prices[i], costPrice);
        }
        return maxProfit < 0 ? 0 : maxProfit; // for cases when input is [7, 6, 4, 3, 1]
    }

    // Variant
    public static int longestSubarrayWithEqualElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int elementCount = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                elementCount++;
            }
            else {
                maxLength = Math.max(elementCount, maxLength);
                elementCount = 1;
            }
        }
        maxLength = Math.max(maxLength, elementCount);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] values = {7, 1, 5, 3, 6, 4, 8};
        //System.out.print(computeProfit(values));
        String s = "apple";
        System.out.println("Test:" + s.substring(s.length()));
    }
}
