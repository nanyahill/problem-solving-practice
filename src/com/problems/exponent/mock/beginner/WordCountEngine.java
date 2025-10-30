package com.problems.exponent.mock.beginner;

import java.io.*;
import java.util.*;

public class WordCountEngine {
    public static String[][] wordCountEngine(String document) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] words = document.trim().split(" ", -1);
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            String word = strip(words[i]);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (a, b) -> Integer.compare(map.get(b), map.get(a)));
        String[][] output = new String[result.size()][2];
        int i = 0;
        for (String s : result) {
            output[i][0] = s;
            output[i][1] = String.valueOf(map.get(s));
            i++;
        }
        return output;
    }

    private static String strip(String s) {
        int writeIdx = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                chars[writeIdx++] = Character.toLowerCase(c);
            }
        }
        return new String(chars, 0, writeIdx);
    }
}
