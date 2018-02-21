package com.problems.epi.test.hash_tables;

import com.problems.epi.code.hash_tables.NearestRepeatedEntries;
import org.junit.Test;

public class NearestRepeatedEntriesTest {

    @Test
    public void findNearestRepeatedEntries() {
        String[] words = { "all", "work", "and", "no", "play", "makes", "jack", "a", "dull", "boy" };
        int expected = -1;
        int actual = NearestRepeatedEntries.findNearestDistance(words);
        assert(expected == actual);
    }
}
