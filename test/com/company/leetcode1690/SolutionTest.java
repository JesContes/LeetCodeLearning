package com.company.leetcode1690;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/3
 */
public class SolutionTest {

    @Test
    public void stoneGameVII() {
        int[] stones = new int[]{5,3,1,4,2};
        Solution solution = new Solution();
        int result = solution.stoneGameVII(stones);
        assertEquals(6, result);
    }

    @Test
    public void stoneGameVII_2() {
        int[] stones = new int[]{721,979,690,84,742,873,31,323,819,22,928,866,118,843,169,818,908,832,852,480,763,715,875,629};
        Solution solution = new Solution();
        int result = solution.stoneGameVII(stones);
        assertEquals(7948, result);
    }
}