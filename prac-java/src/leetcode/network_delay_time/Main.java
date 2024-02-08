package leetcode.network_delay_time;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [[1,2,1],[2,3,2],[1,3,1]]
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
        // int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int result = solution.networkDelayTime(times, 3, 2);
        System.out.println(result);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = -1;
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], e -> new ArrayList<>()).add(new Node(time[1], time[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        int[] distances = new int[n + 1];

        int start = k;
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int vertex = current.vertex;
            if (distances[vertex] < current.cost) continue;
            if (!graph.containsKey(vertex)) continue;

            for (Node node : graph.get(vertex)) {
                int tmp = distances[vertex] + node.cost;
                if (tmp < distances[node.vertex]) {
                    distances[node.vertex] = tmp;
                    pq.offer(new Node(node.vertex, tmp));
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if (distances[i] == Integer.MAX_VALUE) {
                max = -1;
                break;
            }
            if (distances[i] > max) max = distances[i];
        }

        return max;
    }
}

class Node {
    int vertex;

    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}