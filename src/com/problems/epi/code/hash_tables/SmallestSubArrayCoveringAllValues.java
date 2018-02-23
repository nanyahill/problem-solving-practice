package com.problems.epi.code.hash_tables;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestSubArrayCoveringAllValues {

    public static void findSmallestSubArray(String[] str, List<String> set) {
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < str.length; i++) { // update start
            for(int len = i; len < str.length; len++) { // update end
                for(int k = i; k <= len; k++) {
                    System.out.print(str[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"app", "ban", "cat"};
        String[] set = {"ban", "cat"};
        //findSmallestSubArray(input, new ArrayList<>(Arrays.asList(set)));
        findSmallestSubArray(input, Arrays.asList(set));

    }
}
