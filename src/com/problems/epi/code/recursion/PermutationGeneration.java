package com.problems.epi.code.recursion;

import java.util.*;

public class PermutationGeneration {

    public static List<List<Integer>> generatePermutations(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        if (input == null || input.size() == 0) return result;
        generatePermutations(new ArrayList<>(), result, input.size(), input);
        return result;
    }

    private static void generatePermutations(List<Integer> tmp, List<List<Integer>> result, int n, List<Integer> input) {
        if (tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < n; i++) {
                if (tmp.contains(input.get(i))) continue;
                tmp.add(input.get(i));
                generatePermutations(tmp, result, n, input);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generatePermutations(Arrays.asList(2, 3, 5, 7));
        for (List<Integer> set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();

        }
        //System.out.println("abcd".substring(0,0) + "abcd".substring(1));
    }
}
