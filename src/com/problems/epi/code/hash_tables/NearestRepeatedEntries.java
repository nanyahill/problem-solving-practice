package com.problems.epi.code.hash_tables;

import java.util.HashMap;

/** Problem Type: Strings/HashTables
 Pattern: HashTable
 Key Insight:
 - The problem requires to find the nearest distance between two equal entries. How will this distance be computed? (current position - last seen position).
 - A string of words is given and duplicates are our main concern; how can duplicates be identified? (Think, HahsTables)
 - A brute force approach is scan the array and for each element,
   check it with other elements that are equal to it and keep updating the minimum distance seen so far.
   Time complexity: O(n^2) and Space Complexity: O(1)
 - More efficient approach, Based on the problem observation from the first point above,
   we need to always store the last seen position of each word in the hashTable such that when the current entry is equal to an entry in the hashtable,
   we compute the nearest distance (i.e. current position - value in hashtable for given entry).
   Time complexity: O(n) and Space Complexity: O(d), where d is the number of distinct elements in the array.
 */
public class NearestRepeatedEntries {

    public static int findNearestDistance(String[] words) {
        if(words == null || words.length == 0) return -1;
        int nearestDist = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) map.put(words[i], i);
            else {
                nearestDist = Math.min(nearestDist, i - map.get(words[i]));
                map.put(words[i], i);
            }
        }
        return nearestDist != Integer.MAX_VALUE ? nearestDist : -1;
    }
}
