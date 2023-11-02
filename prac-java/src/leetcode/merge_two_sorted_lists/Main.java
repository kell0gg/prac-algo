package leetcode.merge_two_sorted_lists;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6, null)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        while (result.next != null) {
            System.out.println("next => " + result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}