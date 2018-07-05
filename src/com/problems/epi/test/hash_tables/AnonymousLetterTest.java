package com.problems.epi.test.hash_tables;

import com.problems.epi.code.binary_trees.InorderTraversalWithParent;
import com.problems.epi.code.hash_tables.AnonymousLetter;
import org.junit.Test;

import java.util.*;

public class AnonymousLetterTest {

    @Test
    public void isAnonymousLetterConstructibleFromMagazineTest() {
        String letter = "acbabb";
        String magazine = "fedacbbbga";
        boolean expected = true;
        boolean actual = AnonymousLetter.isAnonymousLetterConstructibleFromMagazine(letter, magazine);
        assert(expected == actual);

        HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<String, Integer>(2, 1.1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return this.size() > 2;
            }
        };

        map.put("1", 29);
        map.put("05", 61);
        map.put("2", 3);


        lmap.put("1", 2);
        lmap.put("0", 1);
        lmap.get("1");
        lmap.put("2", 3);

        System.out.print(Arrays.toString(map.values().toArray()));
        System.out.print(Arrays.toString(lmap.values().toArray()));
    }
}
