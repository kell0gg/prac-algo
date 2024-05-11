package leetcode.sort_list;

// https://leetcode.com/problems/sort-list/
public class Main {
}

class Solution {

    // Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
    public ListNode sortList(ListNode head) {
        return divideList(head);
    }

    private ListNode divideList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode half = null, slow = node, fast = node;

        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        half.next = null;
        ListNode l1 = divideList(node);
        ListNode l2 = divideList(slow);

        return mergeTwoLists(l1, l2);
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
