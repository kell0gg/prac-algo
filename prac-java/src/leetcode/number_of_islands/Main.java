package leetcode.number_of_islands;

// https://leetcode.com/problems/number-of-islands/description/
public class Main {
    public static void main(String[] arsg) {
        Solution solution = new Solution();
        char[][] grid = new char[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = '0';
            }
        }
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '1';
        grid[4][3] = '1';

        int result = solution.numIslands(grid);
        System.out.println(result);
    }
}

class Solution {
    private static final char DISCOVERED = '#';
    private static final char ISLAND = '1';
    private static final char WATER = '0';

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == WATER || grid[i][j] == DISCOVERED)
            return;

        grid[i][j] = DISCOVERED;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}