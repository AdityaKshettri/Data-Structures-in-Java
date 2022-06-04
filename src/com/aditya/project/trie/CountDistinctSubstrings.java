package com.aditya.project.trie;

public class CountDistinctSubstrings {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String a = "abab";
        System.out.println(trie.countDistinctSubstrings(a));
    }
}
