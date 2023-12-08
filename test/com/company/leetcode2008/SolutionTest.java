package com.company.leetcode2008;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxTaxiEarnings() {
        int n = 5;
        int[][] rides = new int[][]{{2,5,4},{1,5,1}};
        Solution solution = new Solution();
        long result = solution.maxTaxiEarnings(n, rides);
        assertEquals(7, result);
    }

    @Test
    public void maxTaxiEarnings_2() {
        int n = 20;
        int[][] rides = new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        Solution solution = new Solution();
        long result = solution.maxTaxiEarnings(n, rides);
        assertEquals(20, result);
    }

    @Test
    public void maxTaxiEarnings_3() {
        int n = 10;
        int[][] rides = new int[][]{{9,10,2},{4,5,6},{6,8,1},{1,5,5},{4,9,5},{1,6,5},{4,8,3},{4,7,10},{1,9,8},{2,3,5}};
        Solution solution = new Solution();
        long result = solution.maxTaxiEarnings(n, rides);
        assertEquals(22, result);
    }
}