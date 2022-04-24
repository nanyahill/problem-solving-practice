package com.problems.epi.code.dynamic_programming;

import java.util.*;

public class WordBreakTest1 {
    public static List<String> decomposeIntoDictionaryWords(String name, Set<String> set) {
        //List<String> res = new ArrayList<>();
        if (set == null || set.size() == 0) return Collections.emptyList();
        Map<String, String> memoized = new HashMap<>();
        String res = decomposeIntoDictionaryWords(name, set, memoized);
        if(res != null) {
            String[] res2 = res.split(" ");
            return Arrays.asList(res2);
        }
        else return Collections.emptyList();
        //return Arrays.asList(res2);
    }

    public static String decomposeIntoDictionaryWords(String input, Set<String> dict, Map<String, String> memoized) {

        if (dict.contains(input)) return input;
        if (memoized.containsKey(input)) {
            return memoized.get(input);
        }
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = decomposeIntoDictionaryWords(suffix, dict, memoized);
                if (segSuffix != null) {
                    memoized.put(input, prefix + " " + segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
        }
        memoized.put(input, null);
        return null;
    }
    public static void main(String[] args) {
        String s1 = "rawabawrawr";
        String s2 = "lxqe";
        String s3 = "ppppppp";
        String s4 = "bedbathandbeyond.com";
        Set<String> set = new HashSet<>();
        set.add("raw");
        set.add("abr");
        set.add("bara");
        set.add("rawa");
        set.add("wr");

        set.add("e");
        set.add("lxq");
        set.add("qe");

        set.add("he");
        set.add("hello");
        set.add("hell");
        set.add("lo");

        set.add("pppp");
        set.add("pp");

        set.add("bed");set.add("bath");set.add("hand");set.add("bat");set.add("beyond");set.add("and");
        System.out.print(decomposeIntoDictionaryWords(s4, set));
    }
}
