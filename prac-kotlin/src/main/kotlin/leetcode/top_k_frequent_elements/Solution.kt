package leetcode.top_k_frequent_elements

import java.util.PriorityQueue

// https://leetcode.com/problems/top-k-frequent-elements/description/
fun main() {
    val solution = Solution()
    val result = solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
    println(result)
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = IntArray(k)
        val map: MutableMap<Int, Int> = mutableMapOf()
        val priorityQueue: PriorityQueue<Node> = PriorityQueue(nums.size) { o1: Node, o2: Node ->
            o2.count - o1.count
        }

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        for (entry in map.entries) {
            priorityQueue.add(Node(entry.key, entry.value))
        }


        for (i in 0..<k) {
            if (priorityQueue.isNotEmpty()) {
                result[i] = priorityQueue.poll().num
            } else {
                result[i] = -1
            }
        }
        return result
    }
}

data class Node(val num: Int, val count: Int)