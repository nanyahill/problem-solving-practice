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
        //char[] chars = new char[2*n]; could use a char[] instead of a string
        //findAllValidParens(n, n, chars, result, 0); // 0 is for the array index
        findAllValidParens(n, n, "", result);
        return result;
    }

    private static void findAllValidParens2(int leftCnt, int rightCnt, String prefix, List<String> result) {
        if(leftCnt < 0 || rightCnt < leftCnt) return;
        if(leftCnt == 0 && rightCnt == 0) { // or if(rightCnt == 0)
            result.add(prefix);
            return;
        }
        else { // or have separate if statements for each recursive call as shown below
            findAllValidParens(leftCnt - 1, rightCnt, prefix + "(", result);
            findAllValidParens(leftCnt, rightCnt - 1, prefix + ")", result);
        }
//        if(leftCnt > 0) {
//            findAllValidParens(leftCnt - 1, rightCnt, prefix + "(", result);
//        }
//        if(rightCnt > leftCnt) {
//            findAllValidParens(leftCnt, rightCnt - 1, prefix + ")", result);
//        }
    }

    private static void findAllValidParens(int leftCnt, int rightCnt, String prefix, List<String> result) {
        if(leftCnt == 0) {
            result.add(prefix);
            return;
        }
        if(leftCnt > 0) {
            findAllValidParens(leftCnt - 1, rightCnt, prefix + "(", result);
        }
        if (leftCnt < rightCnt) { // or have separate if statements for each recursive call as shown below
            //findAllValidParens(leftCnt - 1, rightCnt, prefix + "(", result);
            findAllValidParens(leftCnt, rightCnt - 1, prefix + ")", result);
        }
    }
}
