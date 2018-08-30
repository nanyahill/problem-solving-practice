package com.problems.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int count;
    public static boolean canJumpFromPosition(int position, int[] nums) {
        count++;
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public static void canJumpFromPosition2(int position, int[] nums, List<Integer> tmp, List<List<Integer>> list) {
        count++;
        //if(position > furtherestJumpIdx) return false;

        if (position == nums.length - 1) {
            list.add(new ArrayList<>(tmp));
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            tmp.add(position);
            canJumpFromPosition2(nextPosition, nums, tmp, list);
              //  return true;
            //}
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void canJumpFromPosition3(int position, int[] nums, List<Integer> tmp, List<List<Integer>> list) {
        count++;
        //if(position > furtherestJumpIdx) return false;
        if(position == 0) return;
        if (position == nums.length - 1) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            tmp.add(furthestJump);
            canJumpFromPosition3(furthestJump, nums, tmp, list);
            //  return true;
            //}
            //tmp.remove(tmp.size() - 1);
            canJumpFromPosition3(position - 1, nums, tmp, list);
        //}
    }

    public static boolean canJumpFromPosition4(int position, int[] nums, int prev) {
        if (position == nums.length - 1) {
            //list.add(new ArrayList<>(tmp));
            return true;
        }
        if(position <= prev) return false;
        if(position < 0) return false;
        //if(position == 0) return false;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
        //tmp.add(furthestJump);

        //  return true;
        //}
        //tmp.remove(tmp.size() - 1);
        //if(nums[position] > 0) {
//            if(canJumpFromPosition4(furthestJump, nums, position)) {
//                return true;
//            }
//            //else //if(canJumpFromPosition4(position - 1, nums, position))
//               // canJumpFromPosition4(furthestJump - 1, nums, position);
//        }
//        canJumpFromPosition4(furthestJump - 1, nums, position);
//        return false;
        //boolean canJump_Recursive = false;
        boolean fromThisPos = canJumpFromPosition4(furthestJump, nums, position);
        boolean fromNotThisPos = canJumpFromPosition4(position - 1, nums, prev);
        boolean canJump = fromThisPos || fromNotThisPos;
        if(canJump) return true;
        return false;
//        boolean fromThisPos = false;
//        boolean fromNotThisPos = false;
//        if(nums[position] > 0) {
//            fromThisPos = canJumpFromPosition4(furthestJump, nums);
//            if(fromThisPos) fromThisPos = canJumpFromPosition4(position - 1, nums);
//            //fromThisPos = canJumpFromPosition4(furthestJump, nums);
//            //return true;
//        }
//        else fromNotThisPos = canJumpFromPosition4(position - 1, nums);
//        return fromThisPos || fromNotThisPos;
        //return fromThisPos || fromNotThisPos;
        //}
    }

    public static boolean canJump(int[] nums) {
        count = 0;
        return canJumpFromPosition(0, nums);
    }

    public static List<List<Integer>> canJump2(int[] nums) {
        count = 0;
        List<List<Integer>> list = new ArrayList<>();
        canJumpFromPosition2(0, nums, new ArrayList<>(), list);
        return list;
    }

    public static List<List<Integer>> canJump3(int[] nums) {
        count = 0;
        List<List<Integer>> list = new ArrayList<>();
        canJumpFromPosition3(nums.length - 2, nums, new ArrayList<>(), list);
        return list;
    }

    public static boolean canJump4(int[] nums) {
        count = 0;
        return canJumpFromPosition4(0, nums, Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        //int[] nums = {5, 4, 3, 2, 1,0, 1};
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        //int[] nums = {6,5, 4, 3, 2, 1, 1};
//        int[] nums = {3,0,8,2,0,0,1};
        System.out.print(canJump4(nums));
//        List<List<Integer>> result = canJump3(nums);
//        for (List<Integer> set : result) {
//            System.out.print(Arrays.toString(set.toArray()));
//            System.out.println();
//        }
    }
}