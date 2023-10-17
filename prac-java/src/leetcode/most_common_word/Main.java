package leetcode.most_common_word;

import java.util.*;

// https://leetcode.com/problems/most-common-word/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String paragraph = "..Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String result = solution.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();
        String[] words = convertParagraphToWords(paragraph);

        for (String word : words) {
            if (!bannedWords.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private String[] convertParagraphToWords(String paragraph) {
        return paragraph.replaceAll("\\W+", " ").trim().toLowerCase().split(" ");
    }
}