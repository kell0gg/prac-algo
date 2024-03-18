package leetcode.minimum_height_trees


// https://leetcode.com/problems/minimum-height-trees/
fun main() {
    val solution = Solution()
    val result = solution.findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3)))
    result.forEach { println("result :$it") }
}

class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf();
        var leaves = mutableListOf<Int>()
        for (edge in edges) {
            val src = edge[0]
            val dst = edge[1]
            graph.computeIfAbsent(src) { k -> mutableListOf() }.add(dst)
            graph.computeIfAbsent(dst) { k -> mutableListOf() }.add(src)
        }

        for (i in 0 until n) {
            if (graph[i]!!.size == 1) {
                leaves.add(i)
            }
        }

        var tmpN = n;

        while (tmpN > 2) {
            tmpN -= leaves.size
            val tmpleaves = mutableListOf<Int>()
            for (leaf in leaves) {
                val neighbor = graph[leaf]!![0]
                graph[neighbor]!!.remove(leaf)
                if (graph[neighbor]!!.size == 1) {
                    tmpleaves.add(neighbor)
                }
            }
            leaves = tmpleaves
        }
        return leaves
    }
}