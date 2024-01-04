package com.company.leetcode2397;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/4
 */
public class SolutionTest {

    @Test
    public void maximumRows() {
        int[][]matrix = new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}};
        int numSelect = 2;
        Solution solution = new Solution();
        int result = solution.maximumRows(matrix, numSelect);
        assertEquals(3, result);
    }

    @Test
    public void maximumRows_2() {
        int[][]matrix = new int[][]{{1,0,1,0}, {1,0,1,0},{0,1,1,1},{0,1,0,0}};
        int numSelect = 3;
        Solution solution = new Solution();
        int result = solution.maximumRows(matrix, numSelect);
        assertEquals(3, result);
    }
}