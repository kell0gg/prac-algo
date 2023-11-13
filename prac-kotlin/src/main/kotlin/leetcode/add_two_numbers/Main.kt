package leetcode.add_two_numbers

// https://leetcode.com/problems/add-two-numbers/
fun main() {
    val solution = Solution()
    val result = solution.addTwoNumbers(ListNode(1), ListNode(9))
    var current = result
    while (current != null) {
        println(current.`val`)
        current = current.next
    }
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var tmpL1 = l1
        var tmpL2 = l2
        var node = ListNode(0)
        val rootNode = node
        var carry = 0
        while (tmpL1 != null || tmpL2 != null || carry != 0) {
            var sum = 0
            if (tmpL1 != null) {
                sum += tmpL1.`val`
                tmpL1 = tmpL1.next
            }

            if (tmpL2 != null) {
                sum += tmpL2.`val`
                tmpL2 = tmpL2.next
            }

            var remainder = (sum + carry) % 10
            carry = (sum + carry) / 10

            node.next = ListNode(remainder)
            node = node.next!!
        }

        return rootNode.next
    }
}