package leetcode.number_of_islands

// https://leetcode.com/problems/number-of-islands/description/
fun main() {
    val solution = Solution()
    val grid = Array(5) { CharArray(4) }
    for (i in 0..4) {
        for (j in 0..3) {
            grid[i][j] = '0'
        }
    }
    grid[0][0] = '1'
    grid[0][1] = '1'
    grid[0][2] = '1'
    grid[1][0] = '1'
    grid[1][1] = '1'
    grid[1][2] = '1'
    grid[4][3] = '1'
    val result = solution.numIslands(grid)
    println(result)
}

class Solution {
    companion object {
        private const val DISCOVERED = '#'
        private const val ISLAND = '1'
        private const val WATER = '0'
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == ISLAND) {
                    dfs(grid, i, j)
                    count++
                }
            }
        }
        return count
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == DISCOVERED || grid[i][j] == WATER) {
            return
        }

        grid[i][j] = DISCOVERED

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}