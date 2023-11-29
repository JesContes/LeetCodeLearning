package com.company.leetcode1221;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void balancedStringSplitWhenSuccess() {
        String s = "LRLLRRLRLLRR";
        Solution solution = new Solution();
        int result = solution.balancedStringSplit(s);
        assertEquals(4, result);
    }

    @Test
    public void balancedStringSplitWhenCantSplit() {
        String s = "LLLRRLRLRLLRRR";
        Solution solution = new Solution();
        int result = solution.balancedStringSplit(s);
        assertEquals(1, result);
    }
}