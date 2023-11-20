package com.company.leetcode15;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void threeSumWhenMultiPair() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(-1, result.get(0).get(0).intValue());
        assertEquals(-1, result.get(0).get(1).intValue());
        assertEquals(2, result.get(0).get(2).intValue());
        assertEquals(-1, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());
        assertEquals(1, result.get(1).get(2).intValue());
    }

    @Test
    public void threeSumWhenNoPair() {
        int[] nums = new int[]{0,1,1};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(0, result.size());
    }

    @Test
    public void threeSumWhenOnePair() {
        int[] nums = new int[]{0,0,0};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(0, result.get(0).get(1).intValue());
        assertEquals(0, result.get(0).get(2).intValue());
    }
}