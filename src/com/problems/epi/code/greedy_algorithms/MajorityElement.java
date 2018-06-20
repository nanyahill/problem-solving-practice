package com.problems.epi.code.greedy_algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public static String findMajorityElement_BruteForce(List<String> input) {
        if(input == null || input.size() == 0) return "";
        Map<String, Integer> map = new HashMap<>();
        int size = input.size();
        for(String s : input) {
            if(map.containsKey(s)) {
                int count = map.get(s);
                // need to check count before adding so you can return early
                if((count + 1) > (size/2)) return s;
                map.put(s, count + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        return "";
    }

    public static String findMajorityElement_Efficient(Iterator<String> input) {
        if(input == null) return "";
        int counter = 0;
        String candidate = "";
        while(input.hasNext()) {
            String s = input.next();
            if(counter == 0) {
                candidate = s;
                counter++;
            }
            else if(candidate.equals(s)) counter++;
            else counter--;
        }
        return candidate;
    }
}
