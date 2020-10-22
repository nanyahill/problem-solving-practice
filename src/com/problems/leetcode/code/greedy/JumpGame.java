package com.problems.leetcode.code.greedy;

import java.util.Arrays;

public class JumpGame {

    private static int count = 0;

    /******************* Recursive Approach Time: O(n2^n), Space: O(n) **************************
     ***********************************************************************************************/

    public static boolean canJump_Recursive(int[] nums) {
        return canJumpFromPosition_Recursive(0, nums, Integer.MIN_VALUE);
    }

    public static boolean canJumpFromPosition_Recursive(int position, int[] nums, int prevPos) {
        System.out.print(++count);
        if (position == nums.length - 1) {
            return true;
        }
        if (position <= prevPos) return false;
        if (position < 0) return false;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//            if(canJumpFromPosition4(furthestJump, nums, position)) {
//                return true;
//            }
        //}
        // return false;
        //boolean fromThisPos = canJumpFromPosition_Recursive(furthestJump, nums, position);
        //boolean fromNotThisPos = canJumpFromPosition_Recursive(position - 1, nums, prevPos);
        return canJumpFromPosition_Recursive(furthestJump, nums, position) ||
                canJumpFromPosition_Recursive(position - 1, nums, prevPos);
    }

    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            System.out.print(false);
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        System.out.print(false);
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    /******************* Top Down DP Approach Time: O(n^2), Space: O(n) **************************
     ***********************************************************************************************/
    public static boolean canJump_TopDown(int[] nums) {
        int[] cache = new int[nums.length - 1];
        Arrays.fill(cache, -1);
        return canJumpFromPosition_TopDown(0, nums, Integer.MIN_VALUE, cache);
    }

    private static boolean canJumpFromPosition_TopDown(int position, int[] nums, int prevPos, int[] cache) {
        if (position == nums.length - 1) {
            return true;
        }
        if (position <= prevPos) return false;
        if (position < 0) return false;
        if (cache[position] != -1) return cache[position] == 1;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        boolean fromThisPos = canJumpFromPosition_TopDown(furthestJump, nums, position, cache);
        boolean fromNotThisPos = canJumpFromPosition_TopDown(position - 1, nums, prevPos, cache);
        cache[position] = fromThisPos || fromNotThisPos ? 1 : 0;
        return cache[position] == 1;
    }

    /******************* Bottom Up DP Approach Time: O(n^2), Space: O(n) **************************
     * Note: For this problem, starting from index 0 does not give you the benefit of DP because as
     * you go up the cache, all indices still need to be solved.
     * Hence, a less intuitive way is to start from the last index (the destination) and mark it as good
     ***********************************************************************************************/
    public static boolean canJump_BottomUp(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        cache[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) { // because you are building from the last element to 0. See note above.
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (cache[j] == 1) {
                    cache[i] = 1;
                    break;
                }
            }
        }
        return cache[0] == 1;
    }

    /******************* Greedy Approach Time: O(n), Space: O(n) ***********************************
     * Important Observation from bottom-up approach: If we start from the back of the array, if a
     * position is valid, then the position from which it jumped from is also valid.
     ***********************************************************************************************/
    public static boolean canJump_Greedy(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) { // because you are building from the last element to 0. See note above.
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }


    public static boolean canJumpFromPositionx(int position, int[] nums) {
        System.out.print(++count);
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionx(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpx(int[] nums) {
        return canJumpFromPositionx(0, nums);
    }

    public static void main(String[] args) {
        //int[] nums = {5, 4, 3, 2, 1,0, 1};
//        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        //int[] nums = {1,1,1,0};
        //int[] nums = {6,5, 4, 3, 2, 1, 1};
        //int[] nums = {3, 0, 8, 2, 0, 0, 1};
        //System.out.print(canJump_Recursive(nums));
        System.out.println(2 & (1 << 3));
//        List<List<Integer>> result = canJump_Recursive(nums);
//        for (List<Integer> set : result) {
//            System.out.print(Arrays.toString(set.toArray()));
//            System.out.println();
//        }
    }
}
