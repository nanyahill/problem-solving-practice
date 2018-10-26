package com.problems.epi.code.dynamic_programming;

public class NumberOfWaysToClimbStairs {

    public static int numberOfWaysToTop(int n, int k) { // k is the allowed number of jumps that can be made.
        if(n < 0 || k <= 0) return 0;
        if(n <= 1) return 1;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(i >= j)
                    cache[i] += cache[i - j];
            }
        }
        return cache[n];
    }
}
