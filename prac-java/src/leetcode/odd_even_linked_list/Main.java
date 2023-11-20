package leetcode.odd_even_linked_list;

// https://leetcode.com/problems/odd-even-linked-list/
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;

        // 짝수를 뒤로 보내니까 짝수만 확인
        while (even != null && even.next != null) {
            // 연결은 홀수는 홀수, 짝수는 짝수끼리 연결하기 위해 두 칸씩 이동
            odd.next = odd.next.next;
            even.next = even.next.next;

            // 바라보고 있는 노드는 한 칸씩 이동
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}