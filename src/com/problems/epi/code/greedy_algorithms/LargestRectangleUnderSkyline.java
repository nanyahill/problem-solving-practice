package com.problems.epi.code.greedy_algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * The leetcode video to this question helped me understand the solution
 *  NOTE: EPI solution description was long and time consuming
 * https://leetcode.com/problems/largest-rectangle-in-histogram/editorial/
 * There is an nlogn solution which I do not yet understand. That is OK because the O(n) solutions below
 * is more optimal that the nlogn solution.
 * Key Insights for stack solution:
 * Push -1 into the stack after creation.
 * Push current array index to stack if element is greater than what is in top of stack
 * Pop from stack if element is less than what is in top of stack
 * leftlimit = curr array idx; right limit = top of the stack AFTER popping
 * Inside the for loop, we use a a while loop to check that the stack is not empty,
 * the stack top elt is not -1 and the stack top elt is >= curr element
 * Outside the for loop (that is done processing input), it is possible that the stack is not empty
 * Repeat the while loop inside the for loop as long as stack top elt is not -1, with rightlimit = input.size()
 */
public class LargestRectangleUnderSkyline {

    /**
     *  Time: O(n^2)
     *  Space: O(1)
     */
    public static int calculateLargestRectangle_BruteForce(List<Integer> heights) {
        if (heights == null) return -1;
        int maxArea = -1;
        for (int i = 0; i < heights.size(); i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.size(); j++) {
                int width = j - i + 1;
                minHeight = Math.min(minHeight, heights.get(j));
                maxArea = Math.max(maxArea, width * minHeight);
            }
        }
        return maxArea == -1 ? 0 : maxArea;
    }

    /**
     *  Time: O(n)
     *  Space: O(n)
     */
    public static int calculateLargestRectangle_OptimizedWithStack(List<Integer> heights) {
        if(heights == null) return -1;
        int maxArea = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for(int i = 0; i < heights.size(); i++) {
            while(!stack.isEmpty() && stack.peek() != -1 && heights.get(stack.peek()) >= heights.get(i)){
                int poppedIdx = stack.pop();
                int rightLimit = i;
                int leftLimit = stack.peek();
                int width = rightLimit - leftLimit - 1;
                int height = heights.get(poppedIdx);
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        while(!stack.isEmpty() && stack.peek() != -1) {
            int poppedIdx = stack.pop();
            int rightLimit = heights.size();
            int leftLimit = stack.peek();
            int width = rightLimit - leftLimit - 1;
            int height = heights.get(poppedIdx);
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea == -1 ? 0 : maxArea;
    }

    /**
     *  Time: O(n)
     *  Space: O(n)
     */
    public int calculateLargestRectangle_OptimizedWithTwoArrays(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0; // Base Condition
        int maxArea = 0;
        int left[] = new int[n]; //fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        for(int i = 1; i < n; i++){
            int prev = i - 1; // previous for comparing the heights
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }
        // Similarly we do for right
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }
            right[i] = prev;
        }
        // once we have these two arrays fill we need width & area
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;

    }
}
