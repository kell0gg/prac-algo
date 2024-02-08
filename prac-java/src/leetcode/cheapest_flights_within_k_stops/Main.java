package leetcode.cheapest_flights_within_k_stops;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
         */
        // [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        // int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        // [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        // int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int n = 4;
        int result = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], v -> new ArrayList<Node>()).add(new Node(flight[1], flight[2], -1));
        }

        Deque<Node> q = new ArrayDeque<>();
        int[] visitInfos = new int[n];
        Arrays.fill(visitInfos, Integer.MAX_VALUE);
        q.add(new Node(src, 0, -1));

        while (!q.isEmpty()) {
            Node current = q.pollFirst();
            if (current.vertex == dst && current.cost < min) {
                min = current.cost;
            }

            if (!graph.containsKey(current.vertex)) continue;
            for (Node node : graph.get(current.vertex)) {
                int cost = current.cost + node.cost;
                // Time limit exceeded
//                if (current.visitCount < k) {
//                    q.add(new Node(node.vertex, cost, current.visitCount + 1));
//                }
                if (current.visitCount < k && cost < visitInfos[node.vertex]) {
                    visitInfos[node.vertex] = cost;
                    q.add(new Node(node.vertex, cost, current.visitCount + 1));
                }
            }
        }

        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }
}

class Node {
    int vertex;

    int cost;

    int visitCount;

    public Node(int vertex, int cost, int visitCount) {
        this.vertex = vertex;
        this.cost = cost;
        this.visitCount = visitCount;
    }
}