package com.problems.epi.code.hash_tables;

import java.util.HashMap;
import java.util.HashSet;

/** Problem Type: Strings/HashTables
 Pattern: HashTable
 Key Insight:
 - A palindrome is the same forward and backwards.
 - Any string that is a plaindrome will have: each character having an even count except for one charcater that would have an odd count.
 - Since the problem involves counting appearances of characters. (Think HashTables)
 - Optimization: Since the solution involves a comparison between and even vs an odd count, use a Set where you add and remove sequentially- if even count, set will not contain element, if an odd count, set will contain element.
 - Note: Two pointer may some to mind at first since it is a palindrome that is talked about. However, it is a PERMUTATION of a palindrome that is talked about.
 */
public class PalindromePermutation {

    public static boolean isPalindromePermutation(String str) {
        if(str == null || str.length() == 0) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for(Integer num : map.values()) {
            if(num % 2 > 0) oddCount++;
        }
        return oddCount <= 1;
    }

    public static boolean isPalindromePermutation_Optimization(String str) {
        if(str == null || str.length() == 0) return false;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }
}
