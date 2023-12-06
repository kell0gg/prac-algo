package leetcode.remove_duplicate_letters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/remove-duplicate-letters/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println(result);
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Boolean> usedFlagMap = new HashMap<>();
        Deque<Character> deque = new ArrayDeque<>();

        // c b a c d c b c
        // a = 1
        // b = 2
        // c = 4
        // 4 = 1
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);

            if (usedFlagMap.get(s.charAt(i)) != null && usedFlagMap.get(s.charAt(i))) continue;

            while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && countMap.get(deque.peekLast()) > 0) {
                usedFlagMap.put(deque.pollLast(), false);
            }

            deque.addLast(s.charAt(i));
            usedFlagMap.put(s.charAt(i), true);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}