package leetcode.subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 4});
        result.forEach(System.out::println);
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayDeque<>(), 0, result);
        return result;
    }

    private void dfs(int[] nums, Deque<Integer> elements, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(elements));
        for (int i = start; i < nums.length; i++) {
            elements.addLast(nums[i]);
            dfs(nums, elements, i + 1, result);
            elements.pollLast();
        }
    }
}
