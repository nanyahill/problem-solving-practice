package com.problems.epi.code.recursion;

import java.util.*;

public class PermutationGeneration {

    /******************************************* Integers as Input ***************************************************/
    public static List<List<Integer>> generatePermutations(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        if (input == null || input.size() == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            Integer val = map.get(input.get(i));
            if (val == null) map.put(input.get(i), 1);
            else map.put(input.get(i), val + 1);
        }
        //generatePermutations_Duplicates(new ArrayList<>(), result, input.size(), map);
        generatePermutations_Distinct(result, input, 0);
        //generatePermutations_Distinct2(result, input, 0);
        return result;
    }

    private static void generatePermutations_Distinct(List<List<Integer>> result, List<Integer> input, int start) {
        if (start == input.size()) {
            result.add(new ArrayList<>(input));
            return;
        }
        for (int i = start; i < input.size(); i++) {
            Collections.swap(input, i, start);
            generatePermutations_Distinct(result, input, start + 1);
            Collections.swap(input, i, start);
        }

    }


    private static void generatePermutations_Duplicates(List<Integer> tmp, List<List<Integer>> result, int n, Map<Integer, Integer> map) {
        if (tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (Map.Entry entry : map.entrySet()) {
                Integer val = (Integer) entry.getValue();
                if (val > 0) {
                    entry.setValue(val - 1);
                    tmp.add((Integer) entry.getKey());
                    generatePermutations_Duplicates(tmp, result, n, map);
                    entry.setValue(val);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    /******************************************* String as Input ***************************************************/
    public static List<String> generatePermutations_Strings(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer val = map.get(input.charAt(i));
            if (val == null) map.put(input.charAt(i), 1);
            else map.put(input.charAt(i), val + 1);
        }
        generatePermutations_Strings_Distinct("", input, result);
        return result;
    }

    // This is not very efficient due to the string concatenation
    private static void generatePermutations_Strings_Distinct(String perm, String input, List<String> result) {
        if (input.isEmpty()) {
            result.add(perm);
        } else {
            for (int i = 0; i < input.length(); i++) {
                String remaining = input.substring(0, i) + input.substring(i + 1);
                generatePermutations_Strings_Distinct(perm + input.charAt(i), remaining, result);
            }
        }
    }

    private static void generatePermutations_Strings_Distinct_WithSwapping(int l, String input, List<String> result) {
        if (l == input.length() - 1) {
            result.add(input);
            return;
        } else {
            for (int i = l; i < input.length(); i++) {
                swap(input.toCharArray(), i, l);
                generatePermutations_Strings_Distinct_WithSwapping(l + 1, input, result);
                swap(input.toCharArray(), i, l);
            }
        }
    }

    private static void generatePermutations_Strings_Duplicates(List<Integer> tmp, List<List<Integer>> result, int n, Map<Integer, Integer> map) {
        if (tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (Map.Entry entry : map.entrySet()) {
                Integer val = (Integer) entry.getValue();
                if (val > 0) {
                    entry.setValue(val - 1);
                    tmp.add((Integer) entry.getKey());
                    generatePermutations_Duplicates(tmp, result, n, map);
                    entry.setValue(val);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private static void swap(char[] nums, int i, int j) {
        if (nums == null || nums.length == 0) throw new IllegalStateException();
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) return result;

        backtrack(result, nums, new ArrayList<Integer>(), 0);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> currentList, int index) {
        if (currentList.size() == nums.length) {
            result.add(currentList);
            return;
        }

        int n = nums[index];
        for (int i = 0; i <= currentList.size(); i++) {
            List<Integer> copy = new ArrayList<Integer>(currentList);
            copy.add(i, n);
            backtrack(result, nums, copy, index + 1);
        }


    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
//        List<List<Integer>> result = generatePermutations(list);
//        for (List<Integer> set : result) {
//            System.out.print(Arrays.toString(set.toArray()));
//            System.out.println();
//        }
        String s = "cat";
        System.out.println(s.substring(2,2));
//        for(int i = 0; i < s.length(); i++) {
//            String start = i == 0 ? "" : s.substring(0,i);
//            String end = (i + 1) < s.length() ? s.substring(i+1) : "";
//            System.out.print(start + " " + end);
//            System.out.println();
//
//        }
        //permute(a, 0);
    }
}
