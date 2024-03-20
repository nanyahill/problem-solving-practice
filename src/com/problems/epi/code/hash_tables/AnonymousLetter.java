package com.problems.epi.code.hash_tables;

import java.util.HashMap;

/** Problem Type: String */

/** Key Insight:
 - Characters in letter appears no more than the times it appears in magazine (think hashtable since we are considering counts of characters)
 - All characters of the letter must appear in the magazine. Is there a way to check this?
 - Store count of distinct characters of letters in HashMap and then when we see element in magazine, reduce the count of character in the hashmap.
 - Do we really need to use HashMap in Java, will a simple array suffice?
    (Think array of 26 entries (only alphabets) or 256 (extended ascii), clarify with interviewer which is the case)
 Time Complexity: O(n + m) where n = length of letter and m = length of magazine
 Space Complexity: O(l) where l = number of distinct characters in the letter
 */
public class AnonymousLetter {

    public static boolean isAnonymousLetterConstructibleFromMagazine(String letter, String magazine) {
        if(letter == null || letter.length() == 0) return true;
        if(magazine == null || magazine.length() == 0) return false;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < letter.length(); i++) {
            char c_let = letter.charAt(i);
            if(countMap.containsKey(c_let)) countMap.put(c_let, countMap.get(c_let) + 1);
            else countMap.put(c_let, 1);
        }
        for(int j = 0; j < magazine.length(); j++) {
            if(countMap.isEmpty()) return true;
            char c_mag = magazine.charAt(j);
            if(countMap.containsKey(c_mag)) {
                // IMPORTANT: Decrement count as soon as you spot it in the map
                int decrementedCount = countMap.get(c_mag) - 1;
                if(decrementedCount == 0) countMap.remove(c_mag);
                else countMap.put(c_mag, decrementedCount);
            }
        }
        return countMap.isEmpty();
    }
}
