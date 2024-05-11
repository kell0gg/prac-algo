package leetcode.sort_list

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// // https://leetcode.com/problems/sort-list/
fun main() {

}

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        return divideList(head)
    }

    private fun divideList(node: ListNode?): ListNode? {
        if (node?.next == null) return node
        var half: ListNode? = null
        var slow: ListNode? = node
        var fast: ListNode? = node

        while (fast?.next != null) {
            half = slow
            slow = slow!!.next
            fast = fast.next!!.next
        }

        half!!.next = null
        val l1: ListNode? = divideList(node)
        val l2: ListNode? = divideList(slow)

        return mergeTwoLists(l1, l2);
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}