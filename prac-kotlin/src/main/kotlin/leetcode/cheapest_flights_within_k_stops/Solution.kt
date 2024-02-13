package leetcode.cheapest_flights_within_k_stops

import java.util.*
import java.util.Deque
import java.util.ArrayDeque

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
fun main() {

}

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var min = Int.MAX_VALUE
        val graph: MutableMap<Int, MutableList<Node>> = HashMap()
        for (flight in flights) {
            graph.computeIfAbsent(flight[0]) { mutableListOf() }.add(Node(flight[1], flight[2], -1))
        }

        val q: Deque<Node> = ArrayDeque()
        val visitInfos = IntArray(n)
        Arrays.fill(visitInfos, Int.MAX_VALUE)
        q.addLast(Node(src, 0, -1))

        while (!q.isEmpty()) {
            val current = q.pollFirst()

            if (current.vertex == dst && current.cost < min) {
                min = current.cost
            }

            if (!graph.containsKey(current.vertex)) continue

            for (node in graph[current.vertex]!!) {
                val cost = current.cost + node.cost
                if (current.visitCount < k && cost < visitInfos[node.vertex]) {
                    visitInfos[node.vertex] = cost
                    q.addLast(Node(node.vertex, cost, current.visitCount + 1))
                }
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }
}

data class Node(val vertex: Int, val cost: Int, val visitCount: Int)