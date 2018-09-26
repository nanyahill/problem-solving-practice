package com.problems.ctci.chapter10;

public class Question10_5 {

    public static int sparseSearch(String[] words, String key) {
        if(words == null || words.length == 0 || key.isEmpty()) return -1; // Assume user cannot search for an empty string
        int lo = 0, hi = words.length - 1;
        while(lo <= hi) {
            int mid = lo + ((hi - lo)/2);
            if(words[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while(true) {
                    if(left < lo && right > hi) return -1;
                    else if(left >= lo && !words[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    else if(right <= hi && !words[right].isEmpty()) {
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if(words[mid].compareTo(key) > 0) hi = mid - 1;
            else if(words[mid].compareTo(key) < 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
