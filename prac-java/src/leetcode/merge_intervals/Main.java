package leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class Main {
}

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int idx = mergedList.size() - 1;
            if (!mergedList.isEmpty() && intervals[i][0] <= mergedList.get(idx)[1]) {
                mergedList.get(idx)[1] = Math.max(mergedList.get(idx)[1], intervals[i][1]);
            } else {
                mergedList.add(intervals[i]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
