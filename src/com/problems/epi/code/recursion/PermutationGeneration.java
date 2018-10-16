package com.problems.epi.code.recursion;

import java.util.*;

public class PermutationGeneration {

    /******************************************* Integers as Input ***************************************************/
    /*** Distinct Entries ***/

     // Clean solution and prints in lexicographic order
    public static List<List<Integer>> getPerms_Distinct(int[] set) {
        List<List<Integer>> res = new ArrayList<>();
        if (set == null || set.length == 0) return res;
        getPerms_Distinct(new ArrayList<>(), res, 0, set.length, set);
        return res;
    }
    private static void getPerms_Distinct(List<Integer> tmp, List<List<Integer>> res, int idx, int n, int[] set) {
        if(idx == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < n; i++) {
            tmp.add(set[i]);
            getPerms_Distinct(tmp, res, idx + 1, n, set);
            tmp.remove(tmp.size() - 1);
        }
    }

    // TODO- implement perm for distinct using the insertCharAt method of strings
    // TODO- modify perm duplicates to match that for strings in ctci
    /*** duplicate entries ***/
    public static List<List<Integer>> generatePermutations_Duplicates(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        if (input == null || input.size() == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            Integer val = map.get(input.get(i));
            if (val == null) map.put(input.get(i), 1);
            else map.put(input.get(i), val + 1);
        }
        generatePermutations_Duplicates(new ArrayList<>(), result, input.size(), map);
        return result;
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

    /*** Distinct Entries ***/
    public static List<String> getPerms_BuildFromFirstNChars(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        char c = s.charAt(0);
        List<String> perm = getPerms_BuildFromFirstNChars(s.substring(1));
        for (String str : perm) {
            for (int i = 0; i <= str.length(); i++) {
                String newPerm = insertCharAt(str, c, i);
                result.add(newPerm);
            }
        }
        return result;
    }

    private static String insertCharAt(String word, char c, int pos) {
        String start = word.substring(0, pos);
        String end = word.substring(pos);
        return start + c + end;
    }

    // Lexicographic order
    public static List<String> getPerms_BuildByPushingPrefixDownStack(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) return result;
        getPerms_BuildByPushingPrefixDownStack("", input, result);
        return result;
    }

    private static void getPerms_BuildByPushingPrefixDownStack(String perm, String input, List<String> result) {
        if (input.isEmpty()) {
            result.add(perm);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String remaining = input.substring(0, i) + input.substring(i + 1);
            getPerms_BuildByPushingPrefixDownStack(perm + input.charAt(i), remaining, result);
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
        List<List<Integer>> result = getPerms_Distinct(new int[] {1,2,3});
        for (List<Integer> set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();
        }
        String s = "abc";
        //generatePermutations_Strings_Distinct("", s, new ArrayList<>());
        //System.out.println(s.substring(2,2));
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
