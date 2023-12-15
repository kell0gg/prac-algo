package leetcode.k_closest_points_to_origin

// https://leetcode.com/problems/k-closest-points-to-origin/description/
fun main() {

}

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val list = ArrayList<Point>(points.size)
        for (point in points) {
            list.add(
                Point(
                    point[0],
                    point[1],
                    (Math.pow(point[0].toDouble(), 2.0) + Math.pow(point[1].toDouble(), 2.0)).toInt()
                )
            )
        }

        list.sortWith { p1, p2 -> p1.euclid.compareTo(p2.euclid) }

        val result = Array(k) { IntArray(2) { 0 } }

        for (i in 0 until k) {
            result[i][0] = list[i].x
            result[i][1] = list[i].y
        }

        return result
    }
}

data class Point(val x: Int, val y: Int, val euclid: Int)