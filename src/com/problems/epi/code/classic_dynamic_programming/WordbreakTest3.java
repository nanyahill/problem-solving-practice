package com.problems.epi.code.classic_dynamic_programming;

import java.util.*;

public class WordbreakTest3 {
    public static boolean wordBreak_TopDownDP(String input, Set<String> set) {
        if(input == null || set == null || set.size() == 0) return false;
        Map<String, Boolean> memo = new HashMap<>();
        boolean[] memo2 = new boolean[input.length()];
        boolean res = wordBreak_TopDownDP(input, set, memo);
        return res;
    }

    private static boolean wordBreak_TopDownDP(String input, Set<String> set, Map<String, Boolean> memo) {
        if(set.contains(input)) return true;
        if(memo.containsKey(input)) return memo.get(input);
        int len = input.length();
        for(int i = 0; i < len; i++) {
            String prefix = input.substring(0, i + 1);
            if(set.contains(prefix)) {
                String suffix = input.substring(i + 1, len);
                boolean isPresent = wordBreak_TopDownDP(suffix, set, memo);
                if(isPresent == true) {
                    memo.put(input, true);
                    return true;
                }
            }
        }
        memo.put(input, false);
        return false;
    }

    public static boolean wordBreak(String input, Set<String> set) {
        if(input == null || set == null || set.size() == 0) return false;
        //Map<String, Boolean> memo = new HashMap<>();
        //int[] memo2 = new int[input.length() + 1];
        boolean[] table = new boolean[input.length()];
        return wordBreak_BottomUpDP(input, set, table);
    }

    private static boolean wordBreak_BottomUpDP(String input, Set<String> set, boolean[] memo) {
        if(input.length() == 0) return true;
        for(int i = 0; i < input.length(); i++) {
            String prefix = input.substring(0, i + 1);
            if(set.contains(prefix)) memo[i] = true;
            else {
                for(int j = 0; j < i; j++) {
                    if(memo[j] == true && set.contains(input.substring(j + 1, i + 1)))
                        memo[i] = true;
                    break;
                }
            }
        }
        return memo[input.length() - 1];
    }

    public static HashMap<String, ArrayList<String>> wordBreakMap = new HashMap<String, ArrayList<String>>();
    public static ArrayList<String> wordBreakAll(Set<String> dictionary, String text) {
        //if already computed the current substring text then return from map
        if (wordBreakMap.containsKey(text)) {
            return wordBreakMap.get(text);
        }
        ArrayList<String> result = new ArrayList<String>();

        //if the whole word is in the dictionary then we add this to final result
        if (dictionary.contains(text)) {
            result.add(text);
        }

        //try each prefix and extend
        for (int i = 0; i < text.length(); i++) {
            String prefix = text.substring(0, i + 1);
            if (dictionary.contains(prefix)) {
                //extend
                String suffix = text.substring(i + 1);
                ArrayList<String> subRes = wordBreakAll(dictionary, suffix);
                for (String word : subRes) {
                    result.add(prefix + " " + word);
                }
            }
        }

        wordBreakMap.put(text, result);
        return result;
    }

    public static List<String>
    decomposeIntoDictionaryWords(String domain, Set<String> dictionary) {

        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);
        // When the algorithm finishes, lastLength[i] != -1 indicates
        // domain.substring(0, i + 1) has a valid decomposition, and the length of
        // the last string in the decomposition will be lastLength[i].

        for (int i = 0; i < domain.length(); ++i) {
            // If domain.substring(0, i + 1) is a dictionary word, set lastLength[i]
            // to the length of that word.
            if (dictionary.contains(domain.substring(0, i + 1))) {
                lastLength[i] = i + 1;
                continue;
            }

            // If domain.substring(0, i + 1) is not a dictionary word, we look for j <
            // i such that domain.substring(0, j + 1) has a valid decomposition and
            // domain.substring(j + 1, i + 1) is a dictionary word. If so, record the
            // length of that word in lastLength[i].
            for (int j = 0; j < i; ++j) {
                if (lastLength[j] != -1 &&
                        dictionary.contains(domain.substring(j + 1, i + 1))) {
                    lastLength[i] = i - j;
                    break;
                }
            }
        }

        List<String> decompositions = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
            // domain can be assembled by valid words.
            int idx = domain.length() - 1;
            while (idx >= 0) {
                decompositions.add(
                        domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }

    public static void main(String[] args) {
        String s1 = "rawabawrawr";
        String s2 = "lxqe";
        String s3 = "Iamace";
        String s4 = "leetcode";
        String s5 = "ja";
        Set<String> set = new HashSet<>();
        set.add("raw");
        set.add("abr");
        set.add("bara");
        set.add("rawa");
        set.add("wr");

        set.add("e");
        set.add("lxq");
        set.add("qe");

        set.add("I");
        set.add("am");
        set.add("ace");
        set.add("j");
        set.add("a");

        set.add("leet");
        set.add("code");

        System.out.print(decomposeIntoDictionaryWords(s5, set));
    }
}
