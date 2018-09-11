package com.problems.leetcode.code.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nanya on 10/2/17.
 */
public class MaximumAverageSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum / 4);
        }
        return res;
    }

    public static int findMostCommon(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        int dupe = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                dupe = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return dupe;
    }

    public static void main(String[] args) {
        int[] array = {1, 12, -5, -6, 50, 3};
        int[] test = new int[3];
        int k = 4;
        int[] intArr = new int[]{5, 5, 1, 1,};
        //System.out.print(findMaxAverage2(array, k));
        System.out.print(findMostCommon(intArr));
    }
}
