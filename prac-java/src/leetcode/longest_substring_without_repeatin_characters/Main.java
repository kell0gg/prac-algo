package leetcode.longest_substring_without_repeatin_characters;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            } else {
                max = Math.max(max, right - left + 1);
                System.out.printf("%d %d %d\n", max, left, right);
            }
            map.put(c, right);
            right++;
        }

        return max;
    }
}