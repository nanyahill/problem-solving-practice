package com.problems.leetcode.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Nanya on 12/21/17.
 */
public class FindUnsortedSubArray {

    // This solution uses a sorting algorithm
    // Time complexity is O(nlogn)
    // Space Complexity is O(1)
    public static int findUnsortedSubArrayUsingSorting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sorted_nums = nums.clone();
        Arrays.sort(sorted_nums);
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted_nums[i]) {
                start = i;
                break;
            }
        }
        for (int j = nums.length; j >= 0; j--) {
            if (nums[j] != sorted_nums[j]) {
                end = j;
                break;
            }
        }
        return end - start + 1;
    }

    // This solution uses a stack
    // Time complexity is O(n)
    // Space Complexity is O(1)
    public static int findUnsortedSubArrayUsingStack(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i])
                start = Math.min(start, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.empty() && nums[stack.peek()] < nums[j])
                end = Math.max(end, stack.pop());
            stack.push(j);
        }
        return start == Integer.MIN_VALUE || end == Integer.MAX_VALUE ? 0 : end - start + 1;
    }

    // This solution uses a no extra space
    // It is based on the idea from the sorting solution, i.e.
    // Locate the correct position of the min element from the beginning of the array
    // Locate the correct position of the max element from the end of the array
    // Time complexity is O(n)
    // Space complexity is O(1)
    public static int findUnsortedSubArrayUsingNoExtraSpace(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //int min = nums[nums.length - 1], max = nums[0];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) min = Math.min(min, nums[i]);
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > nums[j + 1]) max = Math.max(max, nums[j]);
        }
        int start, end;
        for (start = 0; start < nums.length; start++) {
            if (nums[start] > min) break;
        }
        for (end = nums.length - 1; end >= 0; end--) {
            if (nums[end] < max) break;
        }
        return end - start + 1;
    }
}
