package com.aditya.project.trie;

public class Trie2 {

    private final Node root;

    public Trie2() {
        root = new Node();
    }

    public static void main(String[] args) {
        Trie2 T = new Trie2();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");
        String word1 = "apps";
        System.out.println("Count Words Equal to " + word1 + " " + T.countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count Words Equal to " + word2 + " " + T.countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count Words Starting With " + word3 + " " + T.countWordsStartingWith(word3));
        String word4 = "appl";
        System.out.println("Count Words Starting With " + word4 + " " + T.countWordsStartingWith(word4));
        T.erase(word1);
        System.out.println("Count Words equal to " + word1 + " " + T.countWordsEqualTo(word1));
    }

    // TC : O(N)
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    // TC : O(N)
    public int countWordsEqualTo(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return 0;
            }
        }
        return node.getEnd();
    }

    // TC : O(N)
    public int countWordsStartingWith(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    // TC : O(N)
    public void erase(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
                node.decreasePrefix();
            } else {
                return;
            }
        }
        node.decreaseEnd();
    }

    private static class Node {

        Node[] links = new Node[26];
        int countEndWith = 0;
        int countPrefix = 0;

        public Node() {

        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        public Node get(char c) {
            return links[c - 'a'];
        }

        public int getEnd() {
            return countEndWith;
        }

        public int getPrefix() {
            return countEndWith;
        }

        public void increaseEnd() {
            countEndWith++;
        }

        public void increasePrefix() {
            countPrefix++;
        }

        public void decreaseEnd() {
            countEndWith--;
        }

        public void decreasePrefix() {
            countPrefix--;
        }
    }
}
