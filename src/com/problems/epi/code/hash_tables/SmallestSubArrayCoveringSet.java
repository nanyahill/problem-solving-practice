package com.problems.epi.code.hash_tables;

import java.util.*;

/**
 * Problem Type:HashTables
 Pattern: Sliding Window
 Key Insight:
 - The problem states that the MINIMUM subarray/substring should be found, hence there are multiple subarrays that can be found, but we want the subarray with the minimum length.
 - Possible Algorithms:
 Brute Force: Generate all subarrays then check the length of each for the minimum and return the minium length when found.
 Efficient using Sliding Window: Find the first subarray (window) that contains all elements of the set,
 let say the start and end of this subarray is i and j. Then we know for sure that elements in positions i + 1 and j - 1 do not cover all elements of the set, although elements from i + 1 to j could.
 Hence, when all elements of the set has been found, we try to minimize the window by incrementing i by 1  while keeping j fixed and checking to see if all elements are still covered.
 At any point i = k before j where the all elements are no longer covered, we increment i, break out of the loop and continue incrementing j by 1 until we find another window that contains all the element, then try to minimize it again.

 Algo:
 - Find the first window that contains all the element.
 - When found:
 - Record its left and right pointers.
 - Try to minimize the window by incrementing the left point but first always do the below before incrementing:
 - Check if the left pointer points to an element in the set. If it does and its count is GREATER THAN ZERO
  (if it is 0 or -ve it means that the subarray contains the same element in another position, i.e. has duplicates of the current element),
 then we record that we will be missing this element when we advance the left pointer. This can be stored/recorded in a variable called for example, remainingToCover.

 NOTE: When using strings as input and need to return the substring, watch out for:
 - How you return the substring because Java substring method, includes the start index and excludes the end index
 - possible way: str.substring(startIndex, startIndex + (endIndex - startIndex) + 1) // adding 1 at the end because substring's endIndex is exclusive.
 - Before returning substring check if the final start and end indices are -1 for cases when the given inputs contain the same characters
 */
public class SmallestSubArrayCoveringSet {

    private static class Result {
        public int start;
        public int end;

        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // This method just shows a way the brute force may be solved
    // Generating all the subrrays
    // Note that it this method does not solve the problem
    // Just testing my curiosity about generating all substrings of a sttring
    public static void generateAllSubstringsOfString(String[] str) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) { // update start
            for (int len = i; len < str.length; len++) { // update end
                for (int k = i; k <= len; k++) {
                    System.out.print(str[k] + " ");
                }
                System.out.println();
            }
        }
    }

    /** When using strings as input, watch out for:
     *    - How you return the substring because Java substring method, includes the start index and excludes the end index
     *    - Before returning substring check if the final start and end indices are -1 for cases when the given inputs contain the same characters
     */
    public static String findSmallestSubArrayCoveringAllValues_WithStrings(String str, String ptr) {
        if(ptr == null || str == null) return null;
        if(ptr.length() > str.length()) return null;
        HashMap<Character, Integer> map = new HashMap<>();
        int remainingToCover = ptr.length();
        int minLenLeft = -1;
        int minLenRight = -1;
        for(Character kWord : ptr.toCharArray()) {
            map.put(kWord, map.containsKey(kWord) ? map.get(kWord) + 1 : 1);
        }
        for(int left = 0, right = 0; right < str.length(); ++right) {
            Character word = str.charAt(right);
            if(map.containsKey(word)) {
                map.put(word, map.get(word) - 1);
                int count = map.get(word);
                if(count >= 0) --remainingToCover;
            }
            while(remainingToCover == 0) {
                if((minLenLeft == -1 && minLenRight == -1) || right - left < (minLenRight - minLenLeft)) {
                    minLenLeft = left;
                    minLenRight = right;
                }
                Integer keyWordCount = map.get(str.charAt(left));
                if(keyWordCount != null) {
                    map.put(str.charAt(left), ++keyWordCount);
                    if(keyWordCount > 0) ++remainingToCover;
                }
                ++left;
            }
        }
        return (minLenLeft == -1 && minLenRight == -1) ? "" : str.substring(minLenLeft, minLenLeft + ((minLenRight - minLenLeft) + 1));
    }

    /** Watch out for the following when coding this method:
     *    - How you increment and decrement the character or string count in the hashmap
     *          - increment/decrement the count, store the new value in the map and then test new count value.
     */
    public static Result findShortestSubArray(List<String> strings, Set<String> keywords) {
        Result result = new Result(-1, -1);
        if(strings == null || keywords == null) return result;
        int searchWords = keywords.size();
        // A map is needed despite the hashset given because the exact count of keywords must match that in the shortest
        // subarray. This can be easily verified using a hashmap. Think imagine there are 6 a's in paragraph
        // but only 3 a's in keywords, without map you cannot verify when you have all the 3a's required.
        Map<String, Integer> map = new HashMap<>();
        for(String w : keywords) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        int left = 0;
        for(int right = 0; right < strings.size(); right++) {
            String word = strings.get(right);
            if(map.containsKey(word)) {
                int count = map.get(word);
                --count;
                map.put(word, count);
                // if count < 0 means there are multiple similar strings in input that do not count towards the searchWords.
                if(count >= 0) --searchWords;
            }
            while(searchWords == 0) {
                if(result.start == -1 && result.end == -1 || (right - left) < (result.end - result.start)) {
                    result.start = left;
                    result.end = right;
                }
                word = strings.get(left);
                if(map.containsKey(word)) {
                    int count = map.get(word); // missing word that needs to be found
                    ++count;
                    map.put(word, count); // prefix increment is important!
                    // if count <= 0 means there are multiple similar strings in input that do not count towards the searchWords.
                    if(count > 0) ++searchWords;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"app", "ban", "cat"};
        String[] set = {"ban", "cat", "tak", "vex"};
        Map<String, Integer> map = new HashMap<>();
        for(String word : input) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        int j = 0;
        for(int i = 1; i < set.length; i++) {
            String s = set[i];
            if(map.containsKey(s)) {
                System.out.print("Yes");
                System.out.println();
            }
            String x = set[j];
            if(map.containsKey(x)){
                System.out.print("Nan");
                System.out.println();
                j = j + 2;
            }
        }

    }
}
