package leetcode.reconstruct_itinerary

import java.util.*
import java.util.ArrayDeque
import java.util.Deque

// https://leetcode.com/problems/reconstruct-itinerary/description/
fun main() {
    val tickets: MutableList<List<String>> = ArrayList()
    // tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    // tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    val t1: MutableList<String> = ArrayList()
    t1.add("JFK")
    t1.add("SFO")
    tickets.add(t1)

    val t2: MutableList<String> = ArrayList()
    t2.add("JFK")
    t2.add("ATL")
    tickets.add(t2)

    val t3: MutableList<String> = ArrayList()
    t3.add("SFO")
    t3.add("ATL")
    tickets.add(t3)

    val t4: MutableList<String> = ArrayList()
    t4.add("ATL")
    t4.add("JFK")
    tickets.add(t4)

    val t5: MutableList<String> = ArrayList()
    t5.add("ATL")
    t5.add("SFO")
    tickets.add(t5)

    val solution = Solution()
    solution.findItinerary(tickets)
}

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val results: LinkedList<String> = LinkedList()
        val graph: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        for (ticket in tickets) {
            graph.putIfAbsent(ticket[0], PriorityQueue())
            graph[ticket[0]]!!.add(ticket[1])
        }
        dfs(graph, "JFK", results)
        return results
    }

    fun findItineraryWithStack(tickets: List<List<String>>): List<String> {
        val results: MutableList<String> = LinkedList()
        val stack: Deque<String> = ArrayDeque()
        val graph: MutableMap<String, PriorityQueue<String>> = HashMap()
        for (ticket in tickets) {
            graph.putIfAbsent(ticket[0], PriorityQueue())
            graph[ticket[0]]!!.add(ticket[1])
        }
        stack.addLast("JFK")
        while (!stack.isEmpty()) {
            while (graph.containsKey(stack.peekLast()) && !graph[stack.peekLast()]!!.isEmpty()) {
                stack.addLast(graph[stack.peekLast()]!!.poll())
            }
            results.add(0, stack.pollLast())
        }
        return results
    }

    private fun dfs(graph: MutableMap<String, PriorityQueue<String>>, from: String, results: LinkedList<String>) {
        while (graph.containsKey(from) && graph[from]!!.isNotEmpty()) {
            dfs(graph, graph[from]!!.poll(), results)
        }
        results.add(0, from)
    }
}