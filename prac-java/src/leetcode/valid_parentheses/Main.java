package leetcode.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

// https://leetcode.com/problems/valid-parentheses/description/
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> mappingTable = Map.ofEntries(
            Map.entry(')', '('),
            Map.entry('}', '{'),
            Map.entry(']', '[')
    );

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (mappingTable.containsKey(c)) {
                if (stack.isEmpty() || stack.pollLast() != mappingTable.get(c)) return false;
            } else {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }
}
