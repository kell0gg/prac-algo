package leetcode.odd_even_linked_list

// https://leetcode.com/problems/odd-even-linked-list/
fun main() {

}

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null

        var odd = head
        var even = head.next
        val evenHead = even

        while (even?.next != null) {
            odd!!.next = odd.next!!.next
            even.next = even.next!!.next

            odd = odd.next
            even = even.next
        }
        odd!!.next = evenHead

        return head
    }
}