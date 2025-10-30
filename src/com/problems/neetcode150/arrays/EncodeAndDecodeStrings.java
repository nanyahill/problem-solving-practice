package com.problems.neetcode150.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(":").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < s.length()) {
            int colon = s.indexOf(":", i);
            int size = Integer.valueOf(s.substring(i, colon));
            i = colon + size + 1;
            result.add(s.substring(colon + 1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
