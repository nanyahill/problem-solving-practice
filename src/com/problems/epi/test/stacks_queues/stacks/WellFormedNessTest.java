package com.problems.epi.test.stacks_queues.stacks;

import com.problems.epi.code.stacks_queues.stacks.WellFormedNess;
import org.junit.Test;

public class WellFormedNessTest {

    @Test
    public void isWellFormedTest() {
        String input = "([)]";
        boolean expected = false;
        assert(WellFormedNess.isWellFormed(input) == expected);
    }
}
