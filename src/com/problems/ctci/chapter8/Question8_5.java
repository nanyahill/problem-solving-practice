package com.problems.ctci.chapter8;

public class Question8_5 {

    public static int multiplyTwoNumbers(int x, int y) {
        int smaller = x < y ? x : y;
        int bigger = x < y ? y : x;
        return multiplyTwoNumbersHelper(smaller, bigger);
    }

    private static int multiplyTwoNumbersHelper(int smaller, int bigger) {
        if(smaller == 0) return 0;
        if(smaller == 1) return bigger;
        int s = smaller >>> 1; // take care of -ve nos if not use >>
        int left = multiplyTwoNumbersHelper(s, bigger);
        int right = left;
        if(smaller % 2 == 0) return left + right;
        else return left + right + bigger;
    }
}
