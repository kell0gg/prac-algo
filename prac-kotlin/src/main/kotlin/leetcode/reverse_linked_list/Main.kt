package leetcode.reverse_linked_list

// https://leetcode.com/problems/reverse-linked-list/
fun main() {

}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // return reverse(head, null)
        var prev: ListNode? = null
        var node = head


        while (node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }
        return prev
    }

    // recursive
    private fun reverse(node: ListNode?, prev: ListNode?): ListNode? {
        if (node == null) return prev
        val next: ListNode? = node.next
        node.next = prev
        return reverse(next, node)
    }

}

