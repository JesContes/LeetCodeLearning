package com.company.leetcode2646;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minimumTotalPrice() {
        int n = 4;
        int[][] edges = new int[][]{{0,1},{1,2},{1,3}};
        int[] price = new int[]{2,2,10,6};
        int[][] trips = new int[][]{{0,3},{2,1},{2,3}};
        Solution solution = new Solution();
        assertEquals(23, solution.minimumTotalPrice(n, edges, price, trips));
    }
}