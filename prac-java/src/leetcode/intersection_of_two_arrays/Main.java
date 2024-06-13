package leetcode.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
public class Main {
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        Set<Integer> set = new HashSet<>();

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else {
                if (nums1[index1] > nums2[index2]) {
                    index2++;
                } else {
                    index1++;
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}