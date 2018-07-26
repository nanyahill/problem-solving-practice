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
        generatePermutations_Duplicates(new ArrayList<>(), result, input.size(), map);
        //generatePermutations_Distinct(new ArrayList<>(), result, input.size(), input);
        //generatePermutations_Distinct2(result, input, 0);
        return result;
    }

    private static void generatePermutations_Distinct(List<Integer> tmp, List<List<Integer>> result, int n, List<Integer> input) {
        if (tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < n; i++) {
                if (tmp.contains(input.get(i))) continue;
                tmp.add(input.get(i));
                generatePermutations_Distinct(tmp, result, n, input);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private static void generatePermutations_Distinct_WithSwapping(List<List<Integer>> result, List<Integer> input, int l) {
        if (l == input.size() - 1) {
            result.add(new ArrayList<>(input));
            return;
        } else {
            for (int i = 0; i < input.size(); i++) {
                //if (tmp.contains(input.get(i))) continue;
                Collections.swap(input, i, l);
               // tmp.add(input.get(i));
                generatePermutations_Distinct_WithSwapping(result, input, l + 1);
                //tmp.remove(tmp.size() - 1);
                Collections.swap(input, i, l);
            }
        }
    }

    private static void generatePermutations_Duplicates(List<Integer> tmp, List<List<Integer>> result, int n, Map<Integer, Integer> map) {
        if (tmp.size() == n) {
            //System.out.println(Arrays.toString(tmp.toArray()));
            result.add(new ArrayList<>(tmp));
        } else {
            //for (int i = 0; i < map.size(); i++) {
            for (Map.Entry entry : map.entrySet()) {
                Integer val = (Integer)entry.getValue();
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
        //generatePermutations_Duplicates(new ArrayList<>(), result, input.length(), map);
        generatePermutations_Strings_Distinct("", input, result);
        return result;
    }

    // This is not very efficient due to all the string concatenation
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
                //if (tmp.contains(input.get(i))) continue;
                swap(input.toCharArray(), i, l);
                // tmp.add(input.get(i));
                generatePermutations_Strings_Distinct_WithSwapping(l + 1, input, result);
                //tmp.remove(tmp.size() - 1);
                swap(input.toCharArray(), i, l);
            }
        }
    }

    private static void generatePermutations_Strings_Duplicates(List<Integer> tmp, List<List<Integer>> result, int n, Map<Integer, Integer> map) {
        if (tmp.size() == n) {
            //System.out.println(Arrays.toString(tmp.toArray()));
            result.add(new ArrayList<>(tmp));
        } else {
            //for (int i = 0; i < map.size(); i++) {
            for (Map.Entry entry : map.entrySet()) {
                Integer val = (Integer)entry.getValue();
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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] {1,1,1,2,2,3,3}));
        List<List<Integer>> result = generatePermutations(list);
        for (List<Integer> set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();
        }
    }
}
