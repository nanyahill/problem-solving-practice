package com.problems.epi.code.hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/** Problem Type: Strings/HashTables
 Pattern: HashTable
 Key Insight:
 - A palindrome is the same forward and backwards.
 - Any string that is a plaindrome will have: each character having an even count except for one charcater that would have an odd count.
 - Since the problem involves counting appearances of characters. (Think HashTables)
 - Major Insight: Since the solution involves a comparison between and even vs an odd count, use a Set where you add and remove sequentially- if even count, set will not contain element, if an odd count, set will contain element.
 - Note: Two pointer may seem to come to mind at first since it is a palindrome that is talked about. However, it is a PERMUTATION of a palindrome that is talked about.
 */
public class PalindromePermutation {

    public static boolean isPalindromePermutation(String str) {
        if(str == null || str.isEmpty()) return true;
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()) {
            if(!set.add(c)) set.remove(c);
        }
        return set.size() <= 1;
    }
}
