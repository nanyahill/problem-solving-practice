package com.problems.ctci.chapter10;

public class Question10_10 {

    private static RankNode root = null;

    public static void track(int num) {
        if(root == null) root = new RankNode(num);
        else root.insert(num);
    }

    public static int getRankOfNumber(int num) {
        return root.getRank(num);
    }

    private static class RankNode {
        int data;
        int leftSize;
        RankNode left, right;

        public RankNode(int data) { this.data = data; }

        public void insert(int num) {
            if(num <= data) {
                if(left == null) left = new RankNode(num);
                else left.insert(num);
                leftSize++;
            }
            else {
                if(right == null) right = new RankNode(num);
                else right.insert(num);
            }
        }

        public int getRank(int num) {
            if(num == data) return leftSize;
            else if(num < data) {
                if(left == null) return -1;
                return left.getRank(num);
            }
            else {
                if(right == null) return -1;
                int rightRank = right.getRank(num);
                return rightRank + leftSize + 1;
            }
        }
    }
}
