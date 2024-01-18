package com.company.leetcode2171;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/18
 */
public class SolutionTest {

    @Test
    public void minimumRemoval() {
        int[] beans = {4,1,6,5};
        Solution solution = new Solution();
        long result = solution.minimumRemoval(beans);
        assertEquals(4, result);
    }
}