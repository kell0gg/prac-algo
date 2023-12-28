package basic.graph.bfs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5, 6, 7));
        graph.put(3, List.of());
        graph.put(4, List.of());
        graph.put(5, List.of());
        graph.put(6, List.of());
        graph.put(7, List.of());

        Solution solution = new Solution();
        List<Integer> result = solution.bfs(graph, 1);
        result.forEach(System.out::println);
    }
}

class Solution {
    public List<Integer> bfs(Map<Integer, List<Integer>> graph, int vertex) {
        List<Integer> discovered = new ArrayList<>();
        discovered.add(vertex);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer v = queue.pollFirst();
            for (Integer w : graph.get(v)) {
                discovered.add(w);
                queue.add(w);
            }
        }
        return discovered;
    }
}
