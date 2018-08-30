package com.problems.epi.code.recursion.variants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetDuplicates {

    public static List<List<Integer>> findPowerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        findPowerSet(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void findPowerSet(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            findPowerSet(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
