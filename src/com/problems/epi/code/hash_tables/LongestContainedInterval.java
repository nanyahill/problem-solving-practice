package com.problems.epi.code.hash_tables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedInterval {

    public static int longestContainedRange_Optimized(List<Integer> A) {
        if (A == null || A.isEmpty()) return 0;
        Set<Integer> set = new HashSet<>(A);
        int result = 0;
        for (int num : A) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int upperBound = num + 1;
                while (set.contains(upperBound)) {
                    length++;
                    upperBound++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
