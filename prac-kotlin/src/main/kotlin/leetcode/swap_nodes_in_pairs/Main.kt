package leetcode.swap_nodes_in_pairs

// https://leetcode.com/problems/swap-nodes-in-pairs/
class Main {
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        while (head?.next != null) {
            val p = head.next
            // 현재 노드의 next 는 두 번째 뒤를 바라보도록 함
            head.next = swapPairs(head.next!!.next)
            // 현재 노드의 next 의 next 는 바로 이전 노드를 바라보도록 함
            p!!.next = head
            return p
        }
        return head
    }
}