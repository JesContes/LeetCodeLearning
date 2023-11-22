package com.company.leetcode2304;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 网格中的最小路径代价
     *
     * @param grid 网格
     * @param moveCost 路径代价
     * @return 最小路径代价
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length - 1][grid[0].length];
        System.arraycopy(grid[0], 0, dp[0], 0, grid[0].length);
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int minValue = Integer.MAX_VALUE;
                for (int t = 0; t < grid[0].length; t++) {
                    minValue = Math.min(dp[i-1][t] + moveCost[grid[i-1][t]][j] + grid[i][j], minValue);
                }
                dp[i][j] = minValue;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            int minValue = Integer.MAX_VALUE;
            for (int t = 0; t < grid[0].length; t++) {
                minValue = Math.min(dp[grid.length - 2][t] + moveCost[grid[grid.length - 2][t]][j] + grid[grid.length - 1][j], minValue);
            }
            result = Math.min(result, minValue);
        }
        return result;
    }
}
