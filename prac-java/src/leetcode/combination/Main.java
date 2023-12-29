package leetcode.combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(5, 3);
        result.forEach(System.out::println);
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> elements = new ArrayDeque<>();
        dfs(elements, n, 1, k, result);
        return result;
    }

    private void dfs(Deque<Integer> elements, int count, int start, int remainingCount, List<List<Integer>> result) {
        if (remainingCount == 0) {
            result.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i <= count; i++) {
            elements.addLast(i);
            dfs(elements, count, i + 1, remainingCount - 1, result);
            elements.pollLast();
        }
    }
}
