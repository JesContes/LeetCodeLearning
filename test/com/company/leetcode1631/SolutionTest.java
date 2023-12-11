package com.company.leetcode1631;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minimumEffortPath() {
        int[][] heights = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        Solution solution = new Solution();
        int result = solution.minimumEffortPath(heights);
        assertEquals(1, result);
    }
}