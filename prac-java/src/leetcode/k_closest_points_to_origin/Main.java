package leetcode.k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/k-closest-points-to-origin/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{{1, 3}, {2, -2}};
        int[][] result = solution.kClosest(points, 1);
        for (int[] ints : result) {
            System.out.printf("%d %d \n", ints[0], ints[1]);
        }
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Point> list = new ArrayList<>(points.length);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int euclid = (int) (Math.pow(x, 2) + Math.pow(y, 2));
            list.add(new Point(x, y, euclid));
        }

        list.sort((a, b) -> {
            return Integer.compare(a.euclid, b.euclid);
        });

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = list.get(i).x;
            result[i][1] = list.get(i).y;
        }

        return result;
    }
}

class Point {
    int x, y, euclid;

    public Point(int x, int y, int euclid) {
        this.x = x;
        this.y = y;
        this.euclid = euclid;
    }
}