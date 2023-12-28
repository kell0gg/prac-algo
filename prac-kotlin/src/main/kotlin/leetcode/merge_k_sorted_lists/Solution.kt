package leetcode.merge_k_sorted_lists

import java.util.PriorityQueue

// https://leetcode.com/problems/merge-k-sorted-lists/description/
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val priorityQueue: PriorityQueue<ListNode> = PriorityQueue<ListNode>() { o1, o2 ->
            when {
                o1.`val` == o2.`val` -> 0
                o1.`val` > o2.`val` -> 1
                else -> -1
            }
        }

        val root = ListNode(0)
        var tail = root

        for (node in lists) {
            if(node != null) priorityQueue.add(node)
        }

        while (priorityQueue.isNotEmpty()) {
            tail.next = priorityQueue.poll()
            tail = tail.next!!

            if (tail.next != null) {
                priorityQueue.add(tail.next)
            }
        }
        return root.next
    }
}