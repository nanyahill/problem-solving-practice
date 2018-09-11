package com.problems.leetcode.code.sorting;

import java.util.*;

/**
 * Arrays are unsorted and contain duplicates.
 */
public class IntersectionOfTwoArrays {

    // Return result with unique entries
    public static int[] computeIntersection_UniqueResults(int[] A, int[] B) {
        if (A == null || B == null) return null;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : A) setA.add(num);
        for (int num : B) {
            if (setA.contains(num)) result.add(num);
        }
        int[] intersect = new int[result.size()];
        int i = 0;
        for (int num : result)
            intersect[i++] = num;
        return intersect;
    }

    // Return result with as many times entries show in both arrays
    public static int[] computeIntersection_DupEntries(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        if(A == null || B == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : A) map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        for(int num : B) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if(map.get(num) >= 0) {
                    result.add(num);
                }
            }
        }
        int[] intersect = new int[result.size()];
        for(int i = 0; i < intersect.length; i++) intersect[i] = result.get(i);
        return intersect;
    }
}