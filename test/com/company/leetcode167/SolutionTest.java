package com.company.leetcode167;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void twoSumWhenSuccess() {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, target);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void twoSumWhenSuccess_2() {
        int[] numbers = new int[]{2,3,4};
        int target = 6;
        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, target);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void twoSumWhenSuccess_3() {
        int[] numbers = new int[]{-1,0};
        int target = -1;
        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, target);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }
}