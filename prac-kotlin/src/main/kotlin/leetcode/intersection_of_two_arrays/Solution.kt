package leetcode.intersection_of_two_arrays

import java.util.*

// https://leetcode.com/problems/intersection-of-two-arrays/description/
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums1)
        Arrays.sort(nums2)

        var index1 = 0
        var index2 = 0

        val set: MutableSet<Int> = HashSet()

        while (index1 < nums1.size && index2 < nums2.size) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1])
                index1++
                index2++
            } else {
                if (nums1[index1] > nums2[index2]) {
                    index2++
                } else {
                    index1++
                }
            }
        }
        return set.stream().mapToInt { obj: Int -> obj.toInt() }.toArray()
    }
}