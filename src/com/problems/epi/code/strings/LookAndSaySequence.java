package com.problems.epi.code.strings;


public class LookAndSaySequence {

    /**Concept of the look-and-say sequence: Each entry in the sequence is written as the previous digit read out loud
     * e.g 1211 is read 1 one, 1 two, 2 ones, hence next entry is 111221)
     * 1) In order to find out the nth entry of the sequence;
     * generate all the previous entries of the sequence up to n.
     * Time Complexity: O(n2^n) because each term can have at most twice as many digits as the previous term.
     * Space Complexity: O(1)
     */
    public static String lookAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            int count;
            StringBuilder term = new StringBuilder();
            for(int j = 0; j < s.length(); j++) {
                count = 1;
                char c = s.charAt(j);
                while(j + 1 < s.length() && c == s.charAt(j + 1)) {
                    j++;
                    count++;
                }
                term.append(count);
                term.append(s.charAt(j));
            }
            s = term.toString();
        }
        return s;
    }
}
