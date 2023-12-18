package com.company.leetcode162;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findPeakElement() {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        Solution solution = new Solution();
        int result = solution.findPeakElement(nums);
        assertEquals(5, result);
    }
}