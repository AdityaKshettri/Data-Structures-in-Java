package com.aditya.project.trie;

class Node {

    Node[] links = new Node[26];
    boolean flag = false;

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

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        int n = 5;
        int[] type = {1, 1, 2, 3, 2};
        String[] value = {"hello", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            switch (type[i]) {
                case 1:
                    trie.insert(value[i]);
                    break;
                case 2:
                    if (trie.search(value[i])) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;
                default:
                    if (trie.startsWith(value[i])) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;
            }
        }
    }

    // TC : O(N)
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    // TC : O(N)
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    // TC : O(N)
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }

    // TC : O(N)
    public boolean checkIfPrefixExists(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
                if (!node.isEnd()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // TC : O(N^2)
    // No need of flag
    public int countDistinctSubstrings(String word) {
        int count = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(word.charAt(j))) {
                    node.put(word.charAt(j), new Node());
                    count++;
                }
                node = node.get(word.charAt(j));
            }
        }
        return count + 1;
    }
}
