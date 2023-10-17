package leetcode.longest_palindromic_substring;

// https://leetcode.com/problems/longest-palindromic-substring/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestPalindrome("abba");
        System.out.println(result);
    }
}

class Solution {
    int MAX = 0;
    int LEFT = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }
        return s.substring(LEFT, LEFT + MAX);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int max = right - left - 1;
        if (MAX < max) {
            MAX = max;
            LEFT = left + 1;
        }
    }
}