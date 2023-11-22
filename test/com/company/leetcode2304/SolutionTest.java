package com.company.leetcode2304;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minPathCostWhen2Col3Row() {
        int[][] grid = {{5,3}, {4,0},{2,1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        Solution solution = new Solution();
        int result = solution.minPathCost(grid, moveCost);
        assertEquals(17, result);
    }

    @Test
    public void minPathCostWhen3Col2Row() {
        int[][] grid = {{5,1,2},{4,0,3}};
        int[][] moveCost = {{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}};
        Solution solution = new Solution();
        int result = solution.minPathCost(grid, moveCost);
        assertEquals(6, result);
    }
}