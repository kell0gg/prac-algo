package leetcode.valid_palindrome;

// https://leetcode.com/problems/valid-palindrome/

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean result = solution.isPalindrome("0P");
        System.out.println(result);
    }
}

class Solution {
    private String convertValidString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        String convertedString = convertValidString(s);
        int start = 0;
        int end = convertedString.length() - 1;

        while (start <= end) {
            if (convertedString.charAt(start) != convertedString.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
