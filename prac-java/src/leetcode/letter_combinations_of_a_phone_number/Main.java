package leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("23");
        result.forEach(System.out::println);
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        Map<Character, List<Character>> mapOfDigits = new HashMap<>();
        mapOfDigits.put('0', List.of());
        mapOfDigits.put('1', List.of());
        mapOfDigits.put('2', List.of('a', 'b', 'c'));
        mapOfDigits.put('3', List.of('d', 'e', 'f'));
        mapOfDigits.put('4', List.of('g', 'h', 'i'));
        mapOfDigits.put('5', List.of('j', 'k', 'l'));
        mapOfDigits.put('6', List.of('m', 'n', 'o'));
        mapOfDigits.put('7', List.of('p', 'q', 'r', 's'));
        mapOfDigits.put('8', List.of('t', 'u', 'v'));
        mapOfDigits.put('9', List.of('w', 'x', 'y', 'z'));
        dfs(digits, 0, mapOfDigits, "", result);
        return result;
    }

    private void dfs(String digits, int index, Map<Character, List<Character>> mapOfDigits, String path, List<String> result) {
        if (digits.length() == path.length() || index >= digits.length()) {
            result.add(path);
            return;
        }

        for (Character c : mapOfDigits.get(digits.charAt(index))) {
            dfs(digits, index + 1, mapOfDigits, path + c, result);
        }
    }
}