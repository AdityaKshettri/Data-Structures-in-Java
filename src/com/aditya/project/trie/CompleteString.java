package com.aditya.project.trie;

import java.util.ArrayList;
import java.util.List;

public class CompleteString {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("n");
        inputs.add("ninja");
        inputs.add("nin");
        inputs.add("ni");
        inputs.add("ninj");
        inputs.add("ninga");
        System.out.println("Complete String : " + completeString(inputs));
    }

    // TC : O(N * L)
    public static String completeString(List<String> inputs) {
        Trie trie = new Trie();
        for (String i : inputs) {
            trie.insert(i);
        }
        String longest = "";
        for (String i : inputs) {
            if (trie.checkIfPrefixExists(i)) {
                if (i.length() >= longest.length()) {
                    longest = i;
                }
            }
        }
        return longest.equals("") ? "None" : longest;
    }
}
