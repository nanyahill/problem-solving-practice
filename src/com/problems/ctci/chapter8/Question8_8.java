package com.problems.ctci.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This problem can be easily used for integer inputs.
 * See Leetcode Discuss: Reply from chrislzm in highly voted answer
 */
public class Question8_8 {

    public static List<String> getPerms(String str) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = buildTable(str);
        getPerms(map, str.length(), "", result);
        return result;
    }

    private static void getPerms(Map<Character, Integer> map, int idx, String prefix, List<String> result) {
        if(idx == 0) {
            result.add(prefix);
            return;
        }
        for(Character key : map.keySet()) {
            int count = map.get(key);
            if(count > 0) {
                map.put(key, count - 1);
                getPerms(map, idx - 1, prefix + key, result);
                map.put(key, count);
            }
        }
    }

    private static Map<Character, Integer> buildTable(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
