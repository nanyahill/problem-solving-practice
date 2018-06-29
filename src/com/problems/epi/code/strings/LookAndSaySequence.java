package com.problems.epi.code.strings;


public class LookAndSaySequence {

    /**
     * Concept of the look-and-say sequence: Each entry in the sequence is written as the previous digit read out loud
     * e.g 1211 is read 1 one, 1 two, 2 ones, hence next entry is 111221)
     * 1) In order to find out the nth entry of the sequence;
     * generate all the previous entries of the sequence up to n.
     * Time Complexity: O(n2^n) because each term can have at most twice as many digits as the previous term.
     * Space Complexity: O(1)
     */
    public static String lookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            int count;
            StringBuilder term = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                count = 1;
                char c = s.charAt(j);
                while (j + 1 < s.length() && c == s.charAt(j + 1)) {
                    j++;
                    count++;
                }
//                term.append(count + c); // not a good idea to concatenate
                term.append(count);
                term.append(c);
            }
            s = term.toString();
        }
        return s;
    }

    // Review #2: June 2018
    public static String computeLookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder res = new StringBuilder();
            int count = 0;
            char digit = s.charAt(0);
            for (int j = 0; j < s.length(); j++) {
                if (i == 0 || s.charAt(i) == s.charAt(i - 1)) count++;
                else {
                    count = 1;
                    digit = s.charAt(i);
                }
                res.append(count + digit);
            }
            s = res.toString();
        }
        return s;
    }
}
