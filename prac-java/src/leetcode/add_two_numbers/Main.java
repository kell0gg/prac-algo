package leetcode.add_two_numbers;

// https://leetcode.com/problems/add-two-numbers/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(new ListNode(1, null), new ListNode(9, null));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode root = node;

        int carry = 0;
        while (carry != 0 || l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            node.next = new ListNode(remainder);
            node = node.next;
        }

        return root.next;
    }
}