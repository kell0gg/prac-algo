package leetcode.reverse_linked_list;

// https://leetcode.com/problems/reverse-linked-list/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(4, new ListNode(5, null));

        ListNode current = solution.reverseList(listNode);
        while(current.next!=null){
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println(current.val);
    }
}

class Solution {
    private ListNode reverse(ListNode listNode, ListNode prev) {
        if (listNode == null) return prev;
        ListNode next = listNode.next;
        listNode.next = prev;
        return reverse(next, listNode);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}
