package leetcode.valid_anagram;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/
public class Main {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a1 = s.toCharArray();
        char[] b1 = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != b1[i]) return false;
        }
        return true;
    }
}