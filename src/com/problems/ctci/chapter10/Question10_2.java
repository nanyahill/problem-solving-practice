package com.problems.ctci.chapter10;

import java.util.*;

public class Question10_2 {

    public static List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if(words == null || words.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if(!(map.containsKey(str)))
                map.put(str, new ArrayList<>());
            map.get(str).add(words[i]); // since value of hashmap is an object.
//            if(map.containsKey(str)) {
//                List<String> list = map.get(str);
//                list.add(words[i]);
//                map.put(str, list);
//            }
//            else {
//                List<String> list = new ArrayList<>();
//                list.add(words[i]);
//                map.put(str, list);
//            }
        }
        for(String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
