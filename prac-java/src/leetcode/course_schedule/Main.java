package leetcode.course_schedule;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites = new int[][]{new int[]{0, 1}, {0, 2}, {1, 2}};
        boolean result = solution.canFinish(3, prerequisites);
        System.out.println(result);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph.computeIfAbsent(prerequisites[i][0], it -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        List<Integer> visited = new ArrayList<>();
        List<Integer> alreadyChecked = new ArrayList<>();
        for (Integer finish : graph.keySet()) {
            boolean result = dfs(graph, visited, alreadyChecked, finish);
            if (!result) return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, List<Integer> visited, List<Integer> alreadyChecked, Integer toVisit) {
        if (visited.contains(toVisit)) return false;
        if (alreadyChecked.contains(toVisit)) return true;

        if (graph.containsKey(toVisit)) {
            visited.add(toVisit);
            for (Integer v : graph.get(toVisit)) {
                if (!dfs(graph, visited, alreadyChecked, v)) {
                    return false;
                }
            }
            visited.remove(toVisit);
            alreadyChecked.add(toVisit);
        }
        return true;
    }
}