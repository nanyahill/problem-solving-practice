package com.problems.epi.test.strings;

import com.problems.epi.code.strings.ReverseWordsInSentence;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nanya on 1/8/18.
 */
public class ReverseWordsInSentenceTest {

    @Test
    public void reverseTest() {
        char[] input = {' ',' ','a','l','i','c','e',' ',' ','l','i','k','e','s',' ',' ', ' ', 'b', 'o','t'};
        char[] expected = {'b', 'o', 't', ' ',' ',' ','l','i','k','e','s', ' ', ' ', 'a','l','i','c','e', ' ', ' '};
        char[] actual = ReverseWordsInSentence.reverseWordsInSentence(input);
        Assert.assertArrayEquals(expected, actual);
    }
}
