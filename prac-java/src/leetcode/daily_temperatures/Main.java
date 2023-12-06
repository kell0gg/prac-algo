package leetcode.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/daily-temperatures/description/
public class Main {
}


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                // index 를 꺼내고, 해당 index 에 결과를 업데이트함
                int last = deque.pollLast();
                result[last] = i - last;
            }
            deque.addLast(i);
        }
        return result;
    }
}