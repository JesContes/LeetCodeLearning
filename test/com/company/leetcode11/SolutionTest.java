package com.company.leetcode11;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxArea() {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        int result = solution.maxArea(height);
        assertEquals(49, result);
    }
}