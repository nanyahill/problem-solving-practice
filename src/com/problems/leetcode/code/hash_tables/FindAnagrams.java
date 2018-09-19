package com.problems.leetcode.code.hash_tables;

import java.util.*;

public class FindAnagrams {

    public static List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        int charsFound = p.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, --count);
                if (count >= 0) charsFound--;
            }
            while (charsFound == 0) {
                if ((right - left + 1) == p.length()) result.add(left);
                c = s.charAt(left);
                if (map.containsKey(c)) {
                    int count = map.get(c);
                    map.put(c, ++count);
                    if (count > 0) charsFound++;
                }
                left++;
            }
        }
        return result;
    }

    /**
     * Assuming string contains ONLY English lower case letters
     */
    public static List<Integer> findAllAnagrams_Optimization(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        int charsFound = p.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map[c - 'a']--;
            int count = map[c - 'a'];
            if (count >= 0) charsFound--;
            while (charsFound == 0) {
                if ((right - left + 1) == p.length()) result.add(left);
                c = s.charAt(left);
                map[c - 'a']++;
                count = map[c - 'a'];
                if (count > 0) charsFound++;
                left++;
            }
        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null) return result;
        //MyList[] table = new MyList[26];
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.get(c).add(i);
            }
        }
        for(Character key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int idx : list) {
                int len = 1;
                int k = idx + 1;
                while(k < s.length() && k < p.length()) {
                    if(map.containsKey(s.charAt(k++))) len++;
                    else break;
                    if(len == p.length()) {
                        result.add(idx);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s, p);

    }
}
