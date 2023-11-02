package leetcode.palindrome_linked_list


// https://leetcode.com/problems/palindrome-linked-list/description/
fun main() {
    val solution = Solution()
    solution.isPalindrome(null)
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val deque: ArrayDeque<Int> = ArrayDeque()
        var current = head
        while (current != null) {
            deque.addLast(current.`val`)
            current = current.next
        }
        val size = deque.size

        for (i in 0 until size / 2) {
            if (deque.removeLast() != deque.removeFirst()) return false
        }

        return true
    }
}