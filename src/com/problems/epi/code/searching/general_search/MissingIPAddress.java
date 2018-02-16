package com.problems.epi.code.searching.general_search;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Key Insight:
 - Sequence of IP addresses in a file is not sorted, they are randomly generated.
 - Multiple IP addresses may be missing. Task is to find A missing IP address
 - Each IP address is a 32-bit value
 - Count groups of 16 bits that are similar. In this case the upper 16bits.
 Algorithm
 - The value of IP addresses whose upper 16bits are the same is used to index a count array and increment.
 - Thus, the index of the count array is the upper bits of the IP addresses
 - If the number of IP addresses is exactly 2^31 -1 then there would be 2^16 counts of IP addresses with the same upper bits.
    This is because there lower bits has 2^16 combinations possible.
 - In the problem, one IP address is missing and only 1 billion IP addresses are provided (less than 2^31 - 1),
    hence, there maybe multiple array indices that have count less than 2^16 but we only need to find A missing IP address.
    Hence, we can start with the first index with count less than 2^16.
 - Once the count array has been filled, look for the first index with count less than 2^16.
 - Then find IP addresses whose upper 16 bits match the index found. When an IP address is found, set the lower 16 bits of the IP address.
 - Then for each combination of the lower 16bits ranging from 0 to 2^16 - 1, check if that combination has been set.
    If it has been set then that means that the IP address exists. if is does not then that means it does not exist (i.e. missing).
    To get the missing value, left shift the index of the count array which basically masks out the upper bits, the OR the upper bit with the combination of the lower bit combination to get the missing IP address.
 NOTE: Some good explanation in the EPI book about other inefficient approaches and why they are inefficient. It is worth going over them.
 Time Complexity: O(n) - not sure!
 Space Complexity: O(logn) i.e. 2^16 dominated by the counter
 */
public class MissingIPAddress {

    public static int findMissingIP(List<Integer> seq) {
        if(seq == null | seq.size() == 0) throw new NoSuchElementException("Sequence is empty");
        Iterator<Integer> iter = seq.iterator();
        int bucketCount = 1 << 16;
        int[] counter = new int[bucketCount];
        while(iter.hasNext()) {
            int address = iter.next();
            int index = address >>> 16; // use upper 16 bits as index
            ++counter[index];
        }
        for(int i = 0; i < counter.length; i++) {
            if(counter[i] < bucketCount) { // the array position has address ranges that have missing values
                iter = seq.iterator(); // Search the file again
                BitSet candidates = new BitSet(bucketCount);
                while(iter.hasNext()) {
                    int address = iter.next();
                    if(i == address >>> 16) {
                        candidates.set((bucketCount - 1) & address); // set the lower 16th bit of address
                    }
                }
                for(int j = 0; j < (1 << 16); j++) { // iterates from 0 to (1 << 16) - 1, i.e. lower 16 bits
                    if(!candidates.get(j)) { // checks if the lower 16th bit of address is set
                        return i << 16 | j;
                    }
                }
            }
        }
        throw new IllegalArgumentException("No missing IP address found");
    }
}
