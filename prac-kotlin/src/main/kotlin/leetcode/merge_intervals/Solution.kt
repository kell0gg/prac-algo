package leetcode.merge_intervals

import java.util.*
import kotlin.math.max

// https://leetcode.com/problems/merge-intervals/
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val mergedList: MutableList<IntArray> = ArrayList()
        Arrays.sort(intervals) { a: IntArray, b: IntArray -> a[0] - b[0] }
        for (i in intervals.indices) {
            val idx = mergedList.size - 1
            if (mergedList.isNotEmpty() && intervals[i][0] <= mergedList[idx][1]) {
                mergedList[idx][1] =
                    max(mergedList[idx][1].toDouble(), intervals[i][1].toDouble()).toInt()
            } else {
                mergedList.add(intervals[i])
            }
        }
        return mergedList.toTypedArray<IntArray>()
    }
}