package com.problems.epi.code.greedy_algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Key Insight:
 *
 * [LeetCode #229]For an array of length n:
 * There can be at most one majority element which is more than ⌊n/2⌋ times.
 * There can be at most two majority elements which are more than ⌊n/3⌋ times.
 * There can be at most three majority elements which are more than ⌊n/4⌋ times.
 * and so on.
 * Knowing this can help us understand how we can keep track of majority elements which satisfies O(1)O(1) space requirement.
 *
 * Algorithm:
 * if count == 0: set the curr element to the candidate element and reset count to 1
 * if curr elt is same as candidate: increment count
 * if curr elt is diff from candidate: decrement count
 * Correctness of the algo is that if a majority element truly exists there will be more increases than decreases
 * and the count will be +ve.
 */
public class MajorityElement {

    public static String findMajorityElement_BruteForce(List<String> input) {
        if(input == null || input.size() == 0) return "";
        Map<String, Integer> map = new HashMap<>();
        int size = input.size();
        for(String s : input) {
            if(map.containsKey(s)) {
                int count = map.get(s);
                // need to check count before adding so you can return early
                if((count + 1) > (size/2)) return s;
                map.put(s, count + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        return "";
    }

    public static String findMajorityElement_Efficient(Iterator<String> input) {
        if(input == null) return "";
        int counter = 0;
        String candidate = "";
        while(input.hasNext()) {
            String s = input.next();
            if(counter == 0) {
                candidate = s;
                counter++;
            }
            else if(candidate.equals(s)) counter++;
            else counter--;
        }
        return candidate;
    }
}
