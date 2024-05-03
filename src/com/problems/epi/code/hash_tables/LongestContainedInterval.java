package com.problems.epi.code.hash_tables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The neetcode video to this question helped me understand the solution
 *  NOTE: EPI solution description was long and time consuming
 * https://youtu.be/P6RZZMu_maU?t=91 (video at the point he talks about number line)
 * Key Insights:
 * We need to check if a num exists or not fast. Use Set data structure
 * Start with all input in a Set
 * A start of a seq/interval is when the set does not contain the (curr_number - 1).
 * ** If yes, then initialize a len variable to 1 and iterate forward to get the upperbound
 * */
public class LongestContainedInterval {

    public static int longestContainedRange(List<Integer> A) {
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
