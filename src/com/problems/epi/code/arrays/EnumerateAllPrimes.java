package com.problems.epi.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnumerateAllPrimes {

    /**
     * This is the brute-force solution
     * that uses the idea of primality check
     * for each number ranging from 2...n
     * If the number is a prime, it is
     * added to the result list.
     * Time Complexity: O(n^ 3/2)
     * Space Complexity: O(1)
     */
    public static List<Integer> enumerateAllPrimes(int num) {
        if (num <= 1) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= num; j++) {
                // i != j for the case of i = 2 and i = 3
                // if you don't add the above condition, 2 and 3 are not added
                if (i != j && i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) result.add(i);
        }
        return result;
    }

    /**
     * This is a more efficient solution
     * that uses the idea of a sieve to
     * eliminate all the multiples of primes
     * An array/list of booleans is used as the sieve
     * Time Complexity: O(nloglogn) (because time to sift out multiples of p is proportional to n/p) which is
     * closer to O(n) but better than O(n)
     * Space complexity: O(n)
     */
    public static List<Integer> enumerateAllPrimes2(int n) {
        if(n <= 0) return Collections.emptyList();
        boolean[] bitArray = new boolean[n + 1];
        Arrays.fill(bitArray, true); // Assume all the numbers in the bitarray is a prime (i.e bitarray is set to true);
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(bitArray[i] == false) continue;
            res.add(i);
            for(int j = i*2; j <= n; j+=i) {
                bitArray[j] = false;
            }
        }
        return res;
    }
}
