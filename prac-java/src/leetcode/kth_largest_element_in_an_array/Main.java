package leetcode.kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Main {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}