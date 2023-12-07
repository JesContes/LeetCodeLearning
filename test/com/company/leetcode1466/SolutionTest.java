package com.company.leetcode1466;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minReorder() {
        int n = 6;
        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        Solution solution = new Solution();
        int result = solution.minReorder(n, connections);
        assertEquals(3, result);
    }

    @Test
    public void minReorder_2() {
        int n = 5;
        int[][] connections = new int[][]{{1,0},{1,2},{3,2},{3,4}};
        Solution solution = new Solution();
        int result = solution.minReorder(n, connections);
        assertEquals(2, result);
    }
}