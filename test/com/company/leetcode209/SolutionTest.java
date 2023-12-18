package com.company.leetcode209;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minSubArrayLen() {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        Solution solution = new Solution();
        int result = solution.minSubArrayLen(target, nums);
        assertEquals(2, result);
    }
}