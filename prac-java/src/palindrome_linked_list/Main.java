package palindrome_linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/palindrome-linked-list/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        Boolean result = solution.isPalindrome(node);
        System.out.println(result);
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Deque<Integer> deque = new ArrayDeque<>();
        while (current != null) {
            deque.addLast(current.val);
            current = current.next;
        }

        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            int right = deque.pollLast();
            int left = deque.pollFirst();
            if (left != right) return false;
        }
        return true;
    }
}
