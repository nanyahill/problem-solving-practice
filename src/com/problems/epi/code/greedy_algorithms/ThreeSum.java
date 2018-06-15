package com.problems.epi.code.greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    // Can be implemented iteratively using three nested loops
    // Key idea-is generate permutations of any three entries and check if they sum up to the target
    // Time: O(3^n)
    public static boolean hasThreeSum_BruteForce(List<Integer> nums, int target) {
        if(nums == null || nums.size() == 0) return false;
        return hasThreeSum_BruteForce(nums, target, 0, new ArrayList<>());
    }

    private static boolean hasThreeSum_BruteForce(List<Integer> nums, int target, int partialTarget, List<Integer> tmp) {
        if((tmp.size() == 3 && partialTarget != target)) return false;
        if(tmp.size() == 3 && partialTarget == target) return true;
        for(int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            partialTarget += num;
            tmp.add(num);
            boolean ok = hasThreeSum_BruteForce(nums, target, partialTarget, tmp);
            if(ok == true) return true;
            partialTarget -= num;
            tmp.remove(tmp.size() - 1);
        }
        return false;
    }

    // Time complexity: O(n^2)
    public static boolean hasThreeSum_UsingHashTables(List<Integer> nums, int target) {
        if(nums == null || nums.size() == 0) return false;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                int twosum = nums.get(i) + nums.get(j);
                int remainder = target - twosum;
                if(nums.contains(remainder)) return true; // using input list as the hash table
            }
        }
        return false;
    }

    public static boolean hasThreeSum_Efficient(List<Integer> nums, int target) {
        if(nums == null || nums.size() == 0) return false;
        Collections.sort(nums);
        for(Integer num : nums) {
            int remainder = target - num;
            if(hasTwoSum(nums, remainder) == true) return true;
        }
        return false;
    }

    // Untested Code !
//    public static boolean hasThreeSum_Distinct_Efficient(List<Integer> nums, int target) {
//        if(nums == null || nums.size() == 0) return false;
//        Collections.sort(nums);
//        boolean used = new boolean[nums.size()];
//        for(int i = 0; i < nums.size(); i++) {
//            int remainder = target - nums.get(i);
//            used[i] = true;
//            if(hasTwoSum(nums, remainder, res) == true) return true;
//        }
//        return false;
//    }
//
//    public static List<Integer> hasThreeSum_Distinct_ListAnyResult(List<Integer> nums, int target) {
//        if(nums == null || nums.size() == 0) return false;
//        Collections.sort(nums);
//        List<Integer> res = new ArrayList<>();
//        for(int i = 0; i < nums.size(); i++) {
//            int remainder = target - nums.get(i);
//            res.add(nums.get(i));
//            if(hasTwoSum(nums, remainder, i, res, used) == true) {
//                return res;
//            }
//            else res.remove(res.size() - 1);
//        }
//        return res;
//    }

    private static boolean hasTwoSum(List<Integer> nums, int target) {
        int i = 0, j = nums.size() - 1;
        while(i <= j) {
            int twoSum = nums.get(i) + nums.get(j);
            if(twoSum == target) {
                return true;
            }
            else if(twoSum > target) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);list.add(2);list.add(5);list.add(7);list.add(3);
        System.out.print(hasThreeSum_BruteForce(list, 21));

    }
}
