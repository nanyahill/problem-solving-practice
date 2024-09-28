package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Key Insights:
 * Generate all balanced parentheses points backtracking
 * (Brute force would be inefficient- time wasted in steps that do not lead to the solution)
 * Maintain two variables- leftCount and rightCount that would be a count of the left or right parentheses
 * that can be used to build a valid string.
 * if leftCount > 0, means that there is more left parentheses we can add
 * if leftCount < rightCount, means there is more right parentheses to add BUT no more left parentheses to add
 * if rihtCount == 0, means that the string should be valid (i.e. has a balanced number of parentheses).
 *
 */
public class BalancedParensGeneration {

    public static List<String> generateBalancedParentheses(int n) {
        List<String> result = new ArrayList<>();
        if(n < 0) return result;
        findAllValidParens(n, n, new StringBuilder(), result);
        return result;
    }

    private static void findAllValidParens(int leftCnt, int rightCnt, StringBuilder prefix, List<String> result) {
        if (leftCnt == 0 && rightCnt == 0) {
            result.add(prefix.toString());
            return;
        }
        if (leftCnt > 0) {
            prefix.append("(");
            findAllValidParens(leftCnt - 1, rightCnt, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        if (rightCnt > leftCnt) {
            prefix.append(")");
            findAllValidParens(leftCnt, rightCnt - 1, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
