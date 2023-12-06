package leetcode.daily_temperatures

// https://leetcode.com/problems/daily-temperatures/description/
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val deque: ArrayDeque<Int> = ArrayDeque()
        val result = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.last()]) {
                val last = deque.removeLast()
                result[last] = i - last
            }
            deque.addLast(i)
        }
        return result
    }
}