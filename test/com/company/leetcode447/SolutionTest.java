package com.company.leetcode447;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/8
 */
public class SolutionTest {

    @Test
    public void numberOfBoomerangs() {
        int[][] points = {{0,0},{1,0},{2,0}};
        Solution solution = new Solution();
        int result = solution.numberOfBoomerangs(points);
        assertEquals(2, result);
    }
}