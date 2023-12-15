package com.problems.epi.code.dynamic_programming;

import java.util.*;

// It is important to understand this problem well.
// The given word NEEDS to be decomposed into dictionary words- each character of the word MUST be accounted for.
// That is, Iamace can be decomposed to I am ace. Bamace cannot because B is not accounted for here (is not part
// of any of the matched words- am ace). At each step, the prefix and suffix of the word should be in the dictionary.

// A common variant is that determine if the string is decomposable
// which is simply return true or false. A tricky variant is that if there string is decomposable, list all results of the
// decomposed words. Note that a dictionary word may appear more than once in the input string.
// Note: In tis problem it is tricky to add results to an arraylist in the recursive version of list all results
// because you may end up with words that appear multiple times in the result, e.g. "ja" can result in [a, j, a]
// whereas the result should just be [j, a]
// Easier to just a return a string then split it OR you can use the storing of length of the last word for
// bottom-up approach as in EPI book.
public class BedBathAndBeyondProblem {

    // Determines if the string is decomposable or not
    // Recursive Backtracking Approach
    public static boolean wordBreak_Recursive(String s, Set<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) return false;
        if (wordDict.contains(s)) {
            return true;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, i + 1);
            if (wordDict.contains(prefix)) {
                String suffix = s.substring(i + 1, len);
                boolean isPresent = wordBreak_Recursive(suffix, wordDict);
                if (isPresent == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // Recursion/Backtracking Idea from https://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
//    public static String SegmentString(String input, Set<String> dict) {
//        if (dict.contains(input)) return input;
//        int len = input.length();
//        for (int i = 1; i < len; i++) {
//            String prefix = input.substring(0, i);
//            if (dict.contains(prefix)) {
//                String suffix = input.substring(i, len);
//                String segSuffix = SegmentString(suffix, dict);
//                if (segSuffix != null) {
//                    return prefix + " " + segSuffix;
//                }
//            }
//        }
//        return null;
//    }

    // Lists all results
    // Recursive Backtracking Approach
    public static List<String> wordBreak_Recursive_ListResults(String s, Set<String> dict) {
        if (s == null || dict == null || dict.size() == 0) return Collections.emptyList();
        String res = wordBreak_Recursive_ListResultsUtil(s, dict);
        return res != null ? Arrays.asList(res.split(" ")) : Collections.emptyList();
    }

    private static String wordBreak_Recursive_ListResultsUtil(String s, Set<String> dict) {
        if (dict.contains(s)) {
            return s;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, i + 1);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i + 1, len);
                String subRes = wordBreak_Recursive_ListResultsUtil(suffix, dict);
                if (subRes != null) {
                    return prefix + " " + subRes; // concatenate because the current word is a composition of the prefix and suffix
                }
            }
        }
        return null;
    }

    // Determines if the string is decomposable or not
    public boolean wordBreak_TopDownDp(String s, Set<String> dict) {
        if (s == null || dict == null || dict.size() == 0) return false;
        Map<String, Boolean> map = new HashMap<>();
        return wordBreak_TopDownDp(dict, s, map);
    }

    private static boolean wordBreak_TopDownDp(Set<String> dict, String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        if (dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, i + 1);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i + 1, len);
                boolean isPresent = wordBreak_TopDownDp(dict, suffix, map);
                if (isPresent) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    // List all words in the string that are decomposable into dictionary words
    public static List<String> wordBreak_TopDownDp_ListResults(String s, Set<String> dict) {
        if (dict == null || dict.size() == 0) return Collections.emptyList();
        Map<String, String> memoized = new HashMap<>();
        String res = wordBreak_TopDownDp_ListResults(s, dict, memoized);
        return res != null ? Arrays.asList(res.split(" ")) : Collections.emptyList();
    }

    private static String wordBreak_TopDownDp_ListResults(String input, Set<String> dict, Map<String, String> memoized) {
        if (dict.contains(input)) return input;
        if (memoized.containsKey(input)) {
            return memoized.get(input);
        }
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = wordBreak_TopDownDp_ListResults(suffix, dict, memoized);
                if (segSuffix != null) {
                    memoized.put(input, prefix + " " + segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
        }
        memoized.put(input, null);
        return null;
    }

    // Determine if the string is decomposable or not
    // BottomUp Approach
    public static boolean wordBreak_BottomUp(String s, Set<String> dict) {
        if (s == null || dict == null || dict.size() == 0) return false;
        if (dict.contains(s)) return true; // optimization- return early
        int len = s.length();
        boolean[] table = new boolean[len];
        //table[0] = true;
        // This outer loop is considering each possible length of chars that can be considered
        // i = 0: considers length of 1
        // i = 1: considers length of 2, etc..
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, i + 1);
            if (dict.contains(prefix)) table[i] = true;
            else {
                for (int j = 0; j < i; j++) {
                    String suffix = s.substring(j, i);
                    if (table[j] == true && dict.contains(suffix)) {
                        table[i] = true;
                        break;
                    }
                }
            }
        }
        return table[len-1];
    }

    // List all words in the string that are decomposable into dictionary words
    // BottomUp Approach
    public static List<String> wordBreak_BottomUp_ListResults(String s, Set<String> dict) {
        if (s == null || dict == null || dict.size() == 0) return Collections.emptyList();
        int len = s.length();
        int[] table = new int[len];
        int max = 0;
        for (String word : dict) {
            max = Math.max(max, word.length());
        }
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, i + 1);
            if (dict.contains(prefix))
                table[i] = i + 1; // store the length of the current word obtained from s.substring(0, i+1).
            else {
                // Can improve this for loop by restricting the range of j.
                // If i is greater than the longest dictionary word, the j can range from i-w to i-1
                // else j ranges from 0 to i-1
                //for (int j = Math.max(i-max, 0); j < i; j++) {
                for (int j = 0; j < i; j++) {
                    if (table[j] > 0 && dict.contains(s.substring(j + 1, i + 1))) {
                        table[i] = i - j; // Store the length of the current word obtained from s.substring(j+1, i+1).
                        break;
                    }
                }
            }
        }
        // Get the decompositions from the length of the input string
        // Since they are still stored as lengths in the table array
        List<String> result = new ArrayList<>();
        if (table[len - 1] > 0) { // Only do this if the input string is decomposable
            int idx = len - 1; // start from back of string because the word length is stored in the index of the last char of the word.
            while (idx >= 0) {
                String word = s.substring(idx - table[idx] + 1, len); // OR s.substring(idx - table[idx] + 1, idx + 1);
                len = len - table[idx];
                idx = idx - table[idx];
                result.add(word);
            }
            Collections.reverse(result); // Needed because you are starting from the back of the string so the last decomposed word apears first.
        }
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

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "rawabawrawr";
        String s2 = "ja";
        String s5 = "bamace";
        String s6 = "amanaplanacanal";
        String s7 = "bedbathandbeyond.com";
        String s8 = "leetcode";
        String s9 = "catsanddogs";
        Set<String> set = new HashSet<>();
        //set.add("raw");set.add("abr");set.add("bara");set.add("rawa");
        //set.add("wr");set.add("a");set.add("man");set.add("plan");
        //set.add("canal");set.add("wr");set.add("a");set.add("j");set.add("qe");
        //set.add("I");set.add("am");set.add("ace");set.add("e");set.add("leetcode");set.add("rocks");
        //set.add("bed");set.add("bath");set.add("hand");set.add("bat");set.add("beyond");set.add("and");
        set.add("cat");set.add("cats");set.add("and");set.add("dog");set.add("sand");set.add("dogs");
        //System.out.print(wordBreak_BottomUp(s8, set));

        System.out.println(wordBreak(s9, set));
    }
}
