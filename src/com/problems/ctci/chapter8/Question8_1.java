package com.problems.ctci.chapter8;

/**
 * Top_Down approach (Memoization) was skipped as it is simple/easy to explain and illustrate.
 */
public class Question8_1 {

    public static int countWaysToClimbStairs_Recursive(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return countWaysToClimbStairs_Recursive(n - 1) +
                countWaysToClimbStairs_Recursive(n - 2) +
                countWaysToClimbStairs_Recursive(n - 3);
    }

    private static int countWaysToClimbStairs_BottomUp_ExtraSpace(int n) {
        if(n < 0) return 0;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for(int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        return cache[n];
    }

    private static int countWaysToClimbStairs_BottomUp_ConstantSpace(int n) {
        if(n < 0) return 0;
        int first = 1;
        int second = 1;
        int third = first + second;
        for(int i = 3; i <= n; i++) {
            int fourth = first + second + third;
            first = second;
            second = third;
            third = fourth;
        }
        return third;
    }
}
