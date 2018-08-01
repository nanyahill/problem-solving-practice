package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetGeneration {

    /**
     * This was from a Backtracking template I read from a Leetcode article
     * Not Recommended because it facilitates cramming
     */
    public static List<List<Integer>> generatePowerSet(List<Integer> set) {
        List<List<Integer>> res = new ArrayList<>();
        if (set == null || set.size() == 0) return res;
        generatePowerSet(new ArrayList<>(), res, 0, set.size(), set);
        return res;
    }
    private static void generatePowerSet(List<Integer> tmp, List<List<Integer>> res, int idx, int n, List<Integer> set) {
        res.add(new ArrayList<>(tmp));
        for (int i = idx; i < n; i++) {
            tmp.add(set.get(i));
            generatePowerSet(tmp, res, i + 1, n, set);
            //res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * This was from a Standford CS106b class lecture notes
     * Follows the definition of how to generate subsets
     * All subset can be grouped into two- those that contain it and those that don't
     * Ideal for Strings. Very clean
     */
    private static void generatePowerSet_String(String tmp, String input) {
        if(input.isEmpty()) System.out.println(tmp);
        else {
            generatePowerSet_String(tmp + input.charAt(0), input.substring(1));
            generatePowerSet_String(tmp, input.substring(1));
        }
    }

    /**
     * This was from Competitive programmer Handbook
     * Follows the definition of how to generate subsets
     * All subset can be grouped into two- those that contain it and those that don't
     * Ideal for Integers (since there is no substring method for Java Collections).
     */
    public static List<List<Integer>> generatePowerSet_Integers(List<Integer> set) {
        List<List<Integer>> res = new ArrayList<>();
        if (set == null || set.size() == 0) return res;
        generatePowerSet_Integers(new ArrayList<>(), res, 0, set.size(), set);
        return res;
    }

    private static void generatePowerSet_Integers(List<Integer> tmp, List<List<Integer>> res, int idx, int n, List<Integer> set) {
        if(idx == n) {
            res.add(new ArrayList<>(tmp));
            //System.out.println(tmp.toArray().toString());
        }
        else {
            tmp.add(set.get(idx));
            generatePowerSet_Integers(tmp, res, idx + 1, n, set); // set[i] is included
            //tmp.add(set.get(idx));
            tmp.remove(tmp.size() - 1);
            generatePowerSet_Integers(tmp, res, idx + 1, n, set); // set[i] is not included
            //tmp.remove(tmp.size() - 1);
            //generatePowerSet_Integers(tmp, res, idx + 1, n, set);
        }
    }

    public static List<List<Integer>> generatePowerSet_Iterative(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        if(set == null || set.size() == 0) return result;
        generatePowerSet_Iterative(set, result, set.size());
        return result;
    }

    private static void generatePowerSet_Iterative(List<Integer> set, List<List<Integer>> res, int n) {
        for(int i = 0; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                // to print in squashed order: in which any subset involving aj can be listed only after all the subsets involving a1, . . . , aj−1
                // use index n - j - 1 instead of j
                if((i & (1 << j)) > 0) tmp.add(set.get(j));
            }

            res.add(tmp);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generatePowerSet_Iterative(Arrays.asList(1,2,3));
        for (List<Integer> set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();
        }
//        List<String> res = new ArrayList<>();
//        generatePowerSet_str("", res, 0, 2, "ab");
//        for (String set : res) {
//            System.out.print(set + "---");
//            System.out.println();
//        }
        //System.out.println();
      // generatePowerSet_String("", "ab");
       // System.out.print("Ban");
    }
}
