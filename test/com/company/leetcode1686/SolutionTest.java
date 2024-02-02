package com.company.leetcode1686;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/2
 */
public class SolutionTest {

    @Test
    public void stoneGameVI() {
        int[] aliceValues = new int[]{1,3};
        int[] bobValues = new int[]{2,1};
        Solution solution = new Solution();
        int result = solution.stoneGameVI(aliceValues, bobValues);
        assertEquals(1, result);
    }

    @Test
    public void stoneGameVI_2() {
        int[] aliceValues = new int[]{6,5,1,2,10,6};
        int[] bobValues = new int[]{7,7,7,7,3,7};
        Solution solution = new Solution();
        int result = solution.stoneGameVI(aliceValues, bobValues);
        assertEquals(-1, result);
    }
}