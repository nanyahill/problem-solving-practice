package com.problems.epi.test.searching;

import com.problems.epi.code.searching.general_search.MissingIPAddress;
import org.junit.Test;

import java.util.*;

public class MissingIPAddressTest {

    @Test
    public void missingIPAddress() {
        int n = 990000;
        Random r = new Random();
        Set<Integer> hash = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x;
            do {
                x = r.nextInt(1000000);
            } while (!hash.add(x));
            sequence.add(x);
        }

        int missing = MissingIPAddress.findMissingIP(sequence);
        assert(!hash.contains(missing));
        System.out.println(missing);
    }
}
