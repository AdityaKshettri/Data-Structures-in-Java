package com.aditya.project.array.hashing;

import java.util.HashMap;

// Time Complexity: O(N)
// Auxiliary Space: O(N)
public class _LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println("String a : " + a);
        System.out.println("Longest Substring Without Repeat Length : " + getLongestSubstringWithoutRepeat(a));
    }

    private static int getLongestSubstringWithoutRepeat(String a) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < a.length()) {
            if (map.containsKey(a.charAt(right))) {
                left = Math.max(map.get(a.charAt(right)) + 1, left);
            }
            map.put(a.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
