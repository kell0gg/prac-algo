package leetcode.merge_two_sorted_lists

// https://leetcode.com/problems/merge-two-sorted-lists/
fun main() {
    val solution = Solution()
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(3)

    val list2 = ListNode(2)
    list2.next = ListNode(4)
    list2.next!!.next = ListNode(6)

    var result = solution.mergeTwoLists(list1, list2)
    while (result!!.next != null) {
        println(result.`val`)
        result = result.next
    }
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            return list2
        }
    }
}