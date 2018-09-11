package com.problems.epi.test.playful;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<List<Integer>> generatePowerSet(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.size() == 0) return result;
        generatePowerSet(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void generatePowerSet(List<Integer> nums, int idx, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for(int i = idx; i < nums.size(); i++) {
            tmp.add(nums.get(i));
            generatePowerSet(nums, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

//    @Test
//    public void generatePowerSetTest()

    public static void main(String[] args) {
        Integer[] nums = {0,1,2};
        List<List<Integer>> result = generatePowerSet(Arrays.asList(nums));
        Integer[][] expected = { {}, {0}, {0, 1}, {0, 1, 2}, {0, 2}, {1}, {1, 2}, {2} };
        //List<List<Integer>> expectedList = Arrays.asList(Arrays.asList(expected));
        for(List<Integer> list : result) {
            for(Integer num : list) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

    }
}
