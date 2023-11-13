package leetcode.swap_nodes_in_pairs;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    // recursive
    public ListNode swapPairs(ListNode head) {

        if (head != null && head.next != null) {
            ListNode p = head.next;
            // 현재 node 의 next 는 두 칸 뒤의 node 를 바라보도록 함
            head.next = swapPairs(head.next.next);

            // 현재 node 의 next 의 next 는 이전 노드를 바라볼 수 있도록 함
            p.next = head;
            return p;
        }
        return head;
    }

    public ListNode swapPairsWithLoop(ListNode head) {

        ListNode node = new ListNode(0);
        ListNode root = node;

        node.next = head;

        while (node.next != null && node.next.next != null) {
            ListNode _tmpA = node.next;
            ListNode _tmpB = node.next.next;

            _tmpA.next = _tmpB.next;
            node.next = _tmpB;
            node.next.next = _tmpA;

            node = node.next.next;
        }

        return root.next;
    }

    // with modifying the value
    public ListNode simpleSwapPairs(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            int tmp = node.val;

            node.val = node.next.val;
            node.next.val = tmp;
            node = node.next.next;
        }
        return head;
    }
}