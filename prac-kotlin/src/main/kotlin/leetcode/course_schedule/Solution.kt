package leetcode.course_schedule

// https://leetcode.com/problems/course-schedule/description/
fun main() {
    val solution = Solution()
    val prerequisites = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))
    val result = solution.canFinish(3, prerequisites)
    println(result)
}

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (prerequisite in prerequisites) {
            graph.computeIfAbsent(prerequisite[0]) { mutableListOf() }.add(prerequisite[1])
        }

        val visited: MutableSet<Int> = mutableSetOf()
        val alreadyCheck: MutableSet<Int> = mutableSetOf()

        for (i in graph.keys) {
            if (!dfs(graph, visited, alreadyCheck, i)) {
                return false;
            }
        }

        return true
    }

    private fun dfs(
        graph: MutableMap<Int, MutableList<Int>>,
        visited: MutableSet<Int>,
        alreadyCheck: MutableSet<Int>,
        toVisit: Int,
    ): Boolean {
        if (visited.contains(toVisit)) return false
        if (alreadyCheck.contains(toVisit)) return true

        if (graph.containsKey(toVisit)) {
            visited.add(toVisit)
            for (v in graph[toVisit]!!) {
                if (!dfs(graph, visited, alreadyCheck, v)) {
                    return false
                }
            }
            visited.remove(toVisit)
            alreadyCheck.add(toVisit)
        }
        return true
    }
}