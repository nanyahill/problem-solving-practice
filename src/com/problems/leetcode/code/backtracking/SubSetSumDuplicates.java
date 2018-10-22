package com.problems.leetcode.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode #40
 * 	Notes:
 * 	All numbers (including target) will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 */
public class SubSetSumDuplicates {
    public static List<List<Integer>> findSubsetSum(int[] nums, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        Arrays.sort(nums);
        findSubsetSum(nums, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private static boolean findSubsetSum(int[] nums, int start, int sum, List<Integer> tmp, List<List<Integer>> result) {
        if (sum < 0) {
            System.out.println("tempList: " + Arrays.toString(tmp.toArray()) + " start: " + start);
            return false;
        }
        if (sum == 0) {
            System.out.println("tempList: " + Arrays.toString(tmp.toArray()) + " start: " + start);
            result.add(new ArrayList<>(tmp));
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            System.out.println("tempList: " + Arrays.toString(tmp.toArray()) + " start: " + start + " i: " + i );
            if(i > start && nums[i] == nums[i-1]) continue; // i > start is like saying i > 0 (left border) so that nums[i-1] check does throw an exception.
            tmp.add(nums[i]);
            findSubsetSum(nums, i + 1,sum - nums[i], tmp, result);
            tmp.remove(tmp.size() - 1);
            //System.out.println("Current Sum: " + Arrays.toString(tmp.toArray()) + " current array index: " + start);
            //System.out.print("Current sum is invalid: " + "current sum: " + tmp.toArray() + "current array index: " + start);
        }
        return false;
    }

    public static void main(String[] args) {
        //List<List<Integer>> result = findSubsetSum(new int[]{10,1,2,7,6,1,5}, 8);
//        List<List<Integer>> result = findSubsetSum(new int[]{2, 3, 6, 7}, 7);
        //List<List<Integer>> result = findSubsetSum(new int[] {2, 3, 3, 4, 4, 6}, 15);
        List<List<Integer>> result = findSubsetSum(new int[] {1,4,1}, 5);
//        for (List<Integer> set : result) {
//            System.out.print(Arrays.toString(set.toArray()));
//            System.out.println();
//        }
    }
}
