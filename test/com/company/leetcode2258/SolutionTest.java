package com.company.leetcode2258;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {

    @Test
    public void maximumMinutesSuccess() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,2,0,0,0,0,0}, {0,0,0,2,2,1,0}, {0,2,0,0,1,2,0}, {0,0,2,2,2,0,2}, {0,0,0,0,0,0,0}};
        Assert.assertEquals(3, solution.maximumMinutes(grid));
        grid = new int[][]{{0,2,0,0,1},{0,2,0,2,2},{0,2,0,0,0},{0,0,2,2,0},{0,0,0,0,0}};
        Assert.assertEquals(0, solution.maximumMinutes(grid));
    }

    @Test
    public void cantPassToSafeRoom() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,0,0,0}, {0,1,2,0}, {0,2,0,0}};
        Assert.assertEquals(-1, solution.maximumMinutes(grid));
    }

    @Test
    public void alwaysPassToSafeRoom() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,0,0}, {2,2,0}, {1,2,0}};
        Assert.assertEquals(1000000000, solution.maximumMinutes(grid));
    }
}