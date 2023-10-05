package leetcode.reverse_string;

// https://leetcode.com/problems/reverse-string/

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = new char[]{'a', 'b', 'c'};
        solution.reverseString(s);
        System.out.println(s);
    }
}

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}