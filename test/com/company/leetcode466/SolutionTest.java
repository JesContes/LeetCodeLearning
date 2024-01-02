package com.company.leetcode466;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/2
 */
public class SolutionTest {

    @Test
    public void getMaxRepetitions() {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        Solution solution = new Solution();
        int result = solution.getMaxRepetitions(s1, n1, s2, n2);
        assertEquals(2, result);
    }
}