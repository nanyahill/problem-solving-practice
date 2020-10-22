package com.problems.sandbox;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static List<Job> jobs = new ArrayList<>();
    static PriorityQueue<QueryResult> minHeap = new PriorityQueue<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static void storeDocument(final String document, final int documentNumber) {
        jobs.add(new Job(documentNumber, document));
    }

    public static void performSearch(final String search) {
        for(int i = 0; i < jobs.size(); i++) {
            Job currJob = jobs.get(i);
            String[] jobDescWords = currJob.desc.split(" ");
            Set<String> setOfJobDescWords = new HashSet<>(Arrays.asList(jobDescWords));
            String[] searchWords = search.split(" ");
            int matchCount = 0;
            for(String searchWord : searchWords) {
                if(setOfJobDescWords.contains(searchWord)) matchCount++;
            }
            //QueryResult result = null;
            QueryResult result = new QueryResult(currJob.id, matchCount);
            //else result = new QueryResult(-1, -1);
            minHeap.add(result);
            if(minHeap.size() > 10) minHeap.remove();
        }
        List<Integer> searchResults = processResult();
        printResult(searchResults);
    }

    private static List<Integer> processResult() {
        List<Integer> partialResult = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            QueryResult qr = minHeap.remove();
            partialResult.add(0, qr.jobId);
        }
        return partialResult;
    }

    private static void printResult(List<Integer> searchResults) {
        for(int id : searchResults) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String args[] ) throws Exception {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        final Scanner in = new Scanner(System.in);

        final int N = Integer.parseInt(in.nextLine());
        // Read documents
        for (int i = 0; i < N; i++) {
            storeDocument(in.nextLine(), i);
        }

        final int M = Integer.parseInt(in.nextLine());
        // Read searches
        for (int j = 0; j < M; j++) {
            //System.out.println(performSearch(in.nextLine()));
            performSearch(in.nextLine());
        }
    }

    private static class Job {
        public int id;
        public String desc;

        public Job(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }
    }

    private static class QueryResult implements Comparable<QueryResult> {
        public int jobId;
        public int matchCount;

        public QueryResult(int jobId, int matchCount) {
            this.jobId = jobId;
            this.matchCount = matchCount;
        }

        public int compareTo(QueryResult that) {
            return this.matchCount == that.matchCount ? this.jobId - that.jobId : this.matchCount - that.matchCount;
        }
    }
}
