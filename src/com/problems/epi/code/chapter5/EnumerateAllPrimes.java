package com.problems.epi.code.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nanya on 12/8/17.
 */
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
     * Time Complexity: O(nloglogn) which is
     * closer to O(n)
     * Space complexity: O(n)
     */
    public static List<Integer> enumerateAllPrimes2(int num) {
        if (num <= 1) {
            return new ArrayList<Integer>();
        }
        List<Boolean> lookUpTable = new ArrayList<Boolean>(Collections.nCopies(num + 1, true));
        List<Integer> res = new ArrayList<Integer>();
        lookUpTable.set(0, false);
        lookUpTable.set(1, false);
        for (int i = 2; i <= num; i++) {
            if (lookUpTable.get(i)) {
                res.add(i);
            }
            for (int j = 2 * i; j <= num; j += i) {
                lookUpTable.set(j, false);
            }
        }
        return res;
    }

    public static List<Integer> generateAllPrimes(int n) {
        List<Integer> res = new ArrayList<Integer>();
        //if (n < 2) return (Integer[]) res.toArray();
        int[] sieve = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (sieve[i] != 0) continue;
            for (int j = 2 * i; j <= n; j += i) {
                sieve[j] = i;
            }
            res.add(i);
        }
        Integer[] result = new Integer[res.size()];
        result = res.toArray(result);

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(result));
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
        //Integer[] result = generateAllPrimes(100000);

        System.out.print(generateAllPrimes(100000).size());
        System.out.println();
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println((int)(1000* Math.random()));
        }
    }
}
