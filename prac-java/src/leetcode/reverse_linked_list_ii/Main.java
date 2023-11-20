package leetcode.reverse_linked_list_ii;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode root = new ListNode(0);
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode end = start.next;

        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next;
    }
}
