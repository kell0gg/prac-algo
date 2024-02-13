package leetcode.network_delay_time

import java.util.*

// https://leetcode.com/problems/network-delay-time/
fun main() {
    val solution = Solution()
    val times = arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 2), intArrayOf(1, 3, 1))
    val result = solution.networkDelayTime(times, 3, 2)
    println(result)
}


class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        var max = -1
        val graph: MutableMap<Int, MutableList<Node>> = HashMap()
        for (time in times) {
            graph.computeIfAbsent(time[0]) { e: Int ->
                ArrayList()
            }.add(Node(time[1], time[2]))
        }
        val pq = PriorityQueue { a: Node, b: Node -> a.cost - b.cost }
        val distances = IntArray(n + 1)
        Arrays.fill(distances, Int.MAX_VALUE)
        distances[k] = 0
        pq.offer(Node(k, 0))
        while (!pq.isEmpty()) {
            val current = pq.poll()
            val vertex = current.vertex
            if (distances[vertex] < current.cost) continue
            if (!graph.containsKey(vertex)) continue
            for (node in graph[vertex]!!) {
                val tmp = distances[vertex] + node.cost
                if (tmp < distances[node.vertex]) {
                    distances[node.vertex] = tmp
                    pq.offer(Node(node.vertex, tmp))
                }
            }
        }
        for (i in 1..n) {
            if (i == k) continue
            if (distances[i] == Int.MAX_VALUE) {
                max = -1
                break
            }
            if (distances[i] > max) max = distances[i]
        }
        return max
    }
}


internal class Node(var vertex: Int, var cost: Int)