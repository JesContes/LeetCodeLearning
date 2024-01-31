package com.company.leetcode2670;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/31
 */
public class SolutionTest {

    @Test
    public void distinctDifferenceArray() {
        int[] nums = new int[]{1,2,3,4,5};
        Solution solution = new Solution();
        int[] result = solution.distinctDifferenceArray(nums);
        assertEquals(5, result.length);
        assertEquals(-3, result[0]);
        assertEquals(-1, result[1]);
        assertEquals(1, result[2]);
        assertEquals(3, result[3]);
        assertEquals(5, result[4]);
    }
}