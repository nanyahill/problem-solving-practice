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

        char[] input2 = {' ',' ',' ',' ','a','b',' ', 'b','c',' ',' '};
        char[] expected2 = {'b', 'c', ' ', ' ',' ',' ',' ',' ',' ','a','b'};


       //char[] actual = ReverseWordsInSentence.reverseWordsInSentence(input2);
      // Assert.assertArrayEquals(expected2, actual);

        String s = "    ab bc  ";
        String[] s2 = s.split(" ");
        System.out.print(s2);
    }
}
