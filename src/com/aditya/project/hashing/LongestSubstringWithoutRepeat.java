package com.aditya.project.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time Complexity: O(N)
// Auxiliary Space: O(N)
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println("String a : " + a);
        System.out.println("Longest Substring Without Repeat (Set) : " + funcUsingSet(a));
        System.out.println("Longest Substring Without Repeat (Map) : " + funcUsingMap(a));
    }

    // TC : O(N)*2
    // SC : O(N)
    private static int funcUsingSet(String a) {
        int n = a.length();
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (r < n) {
            if (!set.contains(a.charAt(r))) {
                set.add(a.charAt(r));
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                set.remove(a.charAt(l));
                l++;
            }
        }
        return max;
    }

    // TC : O(N)
    // SC : O(N)
    private static int funcUsingMap(String a) {
        int n = a.length();
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < n) {
            if (map.containsKey(a.charAt(r))) {
                l = Math.max(map.get(a.charAt(r)) + 1, l);
            }
            map.put(a.charAt(r), r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
