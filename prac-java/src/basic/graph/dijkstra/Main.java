package basic.graph.dijkstra;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dijkstra();
    }
}

class Solution {
    public void dijkstra() {
        // graph 생성
        int n = 4;
        int[][] edges = {{1, 2, 4}, {1, 3, 2}, {2, 3, 5}, {2, 4, 10}, {3, 4, 3}};
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        int[] distances = new int[n + 1];

        int start = 1;
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            System.out.println("pq poll => " + current.vertex);
            int vertex = current.vertex;

            if (distances[vertex] < current.cost) continue;
            if (!graph.containsKey(vertex)) continue;

            for (Node node : graph.get(vertex)) {
                // 현재 위치에서 다음 노드로 이동할 때 코스트를 계산하고, 더 적은 값으로 이동할 수 있다면 이동함
                int tmp = distances[vertex] + node.cost;
                if (tmp < distances[node.vertex]) {
                    distances[node.vertex] = tmp;
                    System.out.println("pq add => " + node.vertex);
                    pq.offer(new Node(node.vertex, tmp));
                }
            }
        }

        for (int i = 1; i < distances.length; i++) {
            System.out.printf("%d - %d\n", i, distances[i]);
        }
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