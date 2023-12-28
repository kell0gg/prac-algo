package basic.graph.dfs;

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
        // List<Integer> result = solution.dfs(graph, 1, new ArrayList<>());
        List<Integer> result = solution.iterativeDfs(graph, 1);
        result.forEach(System.out::println);
    }
}

class Solution {
    public List<Integer> dfs(Map<Integer, List<Integer>> graph, int vertex, List<Integer> discovered) {
        discovered.add(vertex);

        for (Integer w : graph.get(vertex)) {
            if (!discovered.contains(w)) {
                discovered = dfs(graph, w, discovered);
            }
        }
        return discovered;
    }

    public List<Integer> iterativeDfs(Map<Integer, List<Integer>> graph, int vertex) {
        List<Integer> discovered = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            vertex = stack.pollLast();
            if (!discovered.contains(vertex)) {
                discovered.add(vertex);
                for (Integer w : graph.get(vertex)) {
                    stack.addLast(w);
                }
            }
        }
        return discovered;
    }
}
