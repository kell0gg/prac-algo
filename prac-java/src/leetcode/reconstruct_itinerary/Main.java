package leetcode.reconstruct_itinerary;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> tickets = new ArrayList<>();
        // tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("SFO");
        tickets.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("ATL");
        tickets.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("ATL");
        tickets.add(t3);

        List<String> t4 = new ArrayList<>();
        t4.add("ATL");
        t4.add("JFK");
        tickets.add(t4);

        List<String> t5 = new ArrayList<>();
        t5.add("ATL");
        t5.add("SFO");
        tickets.add(t5);

        // solution.findItinerary(tickets);
        List<String> results = solution.findItineraryWithStack(tickets);
        results.forEach(System.out::println);
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(graph, "JFK", results);

        return results;
    }

    public List<String> findItineraryWithStack(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        stack.addLast("JFK");
        while (!stack.isEmpty()) {
            while (graph.containsKey(stack.peekLast()) && !graph.get(stack.peekLast()).isEmpty()) {
                stack.addLast(graph.get(stack.peekLast()).poll());
            }
            results.add(0, stack.pollLast());
        }

        return results;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String from, List<String> results) {
        while (graph.containsKey(from) && !graph.get(from).isEmpty()) {
            dfs(graph, graph.get(from).poll(), results);
        }
        results.add(0, from);
    }
}
