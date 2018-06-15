package com.problems.epi.code.dynamic_programming;

import java.util.*;

public class BedBathAndBeyond {
    public static List<String> decomposeIntoDictionaryWords(String name, Set<String> set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.size() == 0) return res;
        decomposeIntoDictionaryWords(name, set, res);
        return res;
    }
    public static void
    decomposeIntoDictionaryWords(String name, Set<String> set, List<String> res) {
        if(name.isEmpty()) return;
        for (int i = 1; i < name.length(); i++) {
            //if(set.contains(name.substring(i, i + 1))) res.add(name.substring(i, i));
            //for(int j = i + 1; j <= name.length(); j++) {
            //if(set.contains(name.substring(i, j))) res.add(name.substring(i, j));
            if (set.contains(name.substring(0, i))) {
                res.add(name.substring(0, i));
                decomposeIntoDictionaryWords(name.substring(i, name.length()), set, res);
                //s1 = setIter.hasNext() ? setIter.next() : null;
            }
        }
        //return res;
    }

    public static List<String> decomposeIntoDictionaryWords2(String name, Set<String> set) {
            List<String> res = new ArrayList<>();
            if (set == null || set.size() == 0) return res;
            return decomposeIntoDictionaryWords2(name, set, res, 1) ? res : Collections.emptyList();
        }

    private static boolean decomposeIntoDictionaryWords2(String name, Set<String> set, List<String> res, int start) {
        if(start > name.length()) return false;
        for (int i = start; i <= name.length(); i++) {
            //if(set.contains(name.substring(i, i + 1))) res.add(name.substring(i, i));
            //for(int j = i + 1; j <= name.length(); j++) {
            //if(set.contains(name.substring(i, j))) res.add(name.substring(i, j));
            if (set.contains(name.substring(0, i)) && decomposeIntoDictionaryWords2(name.substring(i, name.length()), set, res, start)) {
                res.add(name.substring(0, i));
                return true;
                //;
                //s1 = setIter.hasNext() ? setIter.next() : null;
            }
        }
        return false;
    }

    public static String SegmentString(String input, Set<String> dict) {
        if (dict.contains(input)) return input;
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = SegmentString(suffix, dict);
                if (segSuffix != null) {
                    return prefix + " " + segSuffix;
                }
            }
        }
        return null;
    }

    public static List<String> decomposeIntoDictionaryWords_EPI(String domain, Set<String> dictionary) {

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
                //System.out.println(domain.substring(0, j + 1));
                //System.out.println(domain.substring(j + 1, i + 1));
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
                System.out.println(domain.substring(idx + 1 - lastLength[idx], idx + 1));
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
        String s3 = "ppppppp";
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
        set.add("hell");
        set.add("lo");

        set.add("pppp");
        set.add("pp");
        //decomposeIntoDictionaryWords_EPI(s2, set);
        System.out.print(SegmentString(s3, set));
    }
}
