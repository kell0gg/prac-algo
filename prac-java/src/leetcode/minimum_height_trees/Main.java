package leetcode.minimum_height_trees;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        result.forEach(it -> {
            System.out.println("result :" + it);
        });
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
            graph.computeIfAbsent(dst, k -> new ArrayList<>()).add(src);
        }

        // leaf node 를 구함
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            // leaf node 를 제외함
            n -= leaves.size();
            List<Integer> tmpLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Object) leaf);
                if (graph.get(neighbor).size() == 1) {
                    tmpLeaves.add(neighbor);
                }
            }
            leaves = tmpLeaves;
        }
        return leaves;
    }
}

/* Time Limit Exceeded
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> result = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            // 양방향으로 그래프를 만듦
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
            graph.computeIfAbsent(dst, k -> new ArrayList<>()).add(src);
        }

        for (int src : graph.keySet()) {
            int depth = bfs(graph, src);
            result.computeIfAbsent(depth, k -> new ArrayList<>()).add(src);
            if (depth < min) min = depth;
        }
        return result.getOrDefault(min, Arrays.asList(0));
    }

    private int bfs(Map<Integer, List<Integer>> graph, int src) {
        int max = -1;
        boolean[] visited = new boolean[graph.size()];
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(src, 0));
        visited[src] = true;

        while (!deque.isEmpty()) {
            Node current = deque.pollFirst();
            if (current.count > max) max = current.count;
            if (!graph.containsKey(current.val)) continue;
            for (int dst : graph.get(current.val)) {
                if (!visited[dst]) {
                    visited[dst] = true;
                    deque.addLast(new Node(dst, current.count + 1));
                }
            }
        }
        return max;
    }
}

class Node {
    int val;
    int count;

    public Node(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
 */
