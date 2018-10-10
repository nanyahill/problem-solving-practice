package com.problems.epi.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class BalancedParensGeneration {

    public static List<String> generateBalancedParentheses(int n) {
        List<String> result = new ArrayList<>();
        //char[] chars = new char[2*n]; could use a char[] instead of a string
        //findAllValidParens(n, n, chars, result, 0); // 0 is for the array index
        findAllValidParens(n, n, "", result);
        return result;
    }

    private static void findAllValidParens(int leftCnt, int rightCnt, String prefix, List<String> result) {
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
}
