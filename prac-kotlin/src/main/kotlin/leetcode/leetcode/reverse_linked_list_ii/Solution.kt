package leetcode.leetcode.reverse_linked_list_ii


// https://leetcode.com/problems/reverse-linked-list-ii/
fun main() {
    for (i in 0 until 10) {
        println(i)
    }

    for (i in 0..10) {
        println(i)
    }
}

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null
        val root = ListNode(0)
        root.next = head

        var start = root as ListNode?
        for (i in 0 until left - 1) start = start!!.next
        val end = start!!.next

        for (i in 0 until right - left) {
            val tmp = start.next
            start.next = end!!.next
            end.next = end.next!!.next
            start.next!!.next = tmp
        }
        return root.next
    }
}