package com.problems.epi.code.arrays;

import java.util.*;

public class RandomSubSet {
    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Random rand = new Random();
        for(int i = 0; i < k; i++) {
            int randIdx = i + rand.nextInt(n - i);
            Integer ptr1 = map.get(randIdx);
            Integer ptr2 = map.get(i);
            if(ptr1 == null && ptr2 == null) {
                map.put(randIdx, i);
                map.put(i, randIdx);
            }
            else if (ptr1 != null && ptr2 == null) {
                map.put(i, ptr1);
                map.put(randIdx, i);
            }
            else if (ptr1 == null && ptr2 != null) {
                map.put(randIdx, ptr2);
                map.put(i, randIdx);
            }
            else {
                map.put(randIdx, ptr2);
                map.put(i, ptr1);
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for(int i = 0; i < k; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
