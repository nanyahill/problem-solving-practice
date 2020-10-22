package com.problems.ctci.chapter4;

import java.util.Random;

public class Question4_11 {
    public class TreeRandom {

        public TreeRandomNode root = null;

        public void insert(int d) {
            if (root == null) root = new TreeRandomNode(d);
            else root.insert(d);
        }

//        public TreeRandomNode delete(int d) {
//            if (root == null) return null;
//            else return root.delete(d);
//        }

        public TreeRandomNode find(int d) {
            if (root == null) return null;
            else return root.find(d);
        }

        public TreeRandomNode getRandomNode() {
            if (root == null) return null;
            else return root.getRandomNode();
        }
    }

    private static class TreeRandomNode {

        int data;
        TreeRandomNode left;
        TreeRandomNode right;
        int size;

        public TreeRandomNode(int d) {
            data = d;
            size = 1;
        }

        private void insert(int d) {
            if (d <= data) {
                if (left == null) left = new TreeRandomNode(d);
                else left.insert(d);
            } else {
                if (right == null) right = new TreeRandomNode(d);
                else right.insert(d);
            }
            size++;
        }

        private TreeRandomNode getRandomNode() {
            int leftSize = left == null ? 0 : left.size;
            Random rand = new Random();
            int idx = rand.nextInt(size);
            if (idx < leftSize) {
                return left.getRandomNode();
            } else if (idx == leftSize) return this;
            /**
             * Note that this can never give a null pointer exception
             * because if right is null it means leftSize is either x or 0
             * if leftsize is 0, it means the size is 1 and idx == leftsize (0 == 0)
             */
            else return right.getRandomNode();
        }

//        private TreeRandomNode delete(int d) {
//            if (d < data) {
//                if (left == null) return null;
//                else return left.delete(d);
//            } else if (d == data) return this;
//            else {
//                if (right == null) return null;
//                else return right.delete(d);
//            }
//        }

        private TreeRandomNode find(int d) {
            if (d < data) {
                if (left == null) return null;
                else return left.find(d);
            } else if (d == data) return this;
            else {
                if (right == null) return null;
                else return right.find(d);
            }
        }
    }
}
