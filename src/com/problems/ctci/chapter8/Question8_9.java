package com.problems.ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Question8_9 {

    public static List<String> generateBalancedParentheses(int n) {
        List<String> result = new ArrayList<>();
//        char[] chars = new char[2*n];
        findAllValidParens(n, n, "", result);
//        findAllValidParens(n, n, chars, result, 0);
        return result;
    }

//  private static void findAllValidParens(int leftCnt, int rightCnt, char[] prefix, List<String> result, int count) {
    private static void findAllValidParens(int leftCnt, int rightCnt, String prefix, List<String> result) {
        if (leftCnt == 0 && rightCnt == 0) {
            result.add(prefix);
            return;
        }
        if (leftCnt < 0 || rightCnt < leftCnt) return;
        //prefix[count] = '(';
        findAllValidParens(
                leftCnt - 1, rightCnt, prefix + "(", result);
        //prefix[count] = ')';
        findAllValidParens(leftCnt, rightCnt - 1, prefix + ")", result);
    }
}
