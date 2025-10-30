package com.problems.sandbox;

public class JavaPassByVAlueTest {
    TrieNode root;

    public JavaPassByVAlueTest() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.contains(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        public boolean contains(char c){
            return children[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public void put(char c) {
            TrieNode node = new TrieNode();
            children[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
    public static void main(String[] args) {
        JavaPassByVAlueTest obj = new JavaPassByVAlueTest();
        obj.addWord("bad");
        obj.addWord("dad");
        System.out.println(obj.root.children);
        //obj.addWord("dad");
        //obj.addWord("padg");
    }
}
