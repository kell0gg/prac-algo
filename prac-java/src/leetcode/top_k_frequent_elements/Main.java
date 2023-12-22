package leetcode.top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3
        }, 2);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            priorityQueue.add(new Node(num, map.get(num)));
        }

        for (int i = 0; i < k; i++) {
            if (!priorityQueue.isEmpty()) {
                result[i] = priorityQueue.poll().num;
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}

class Node {
    int num;
    int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}