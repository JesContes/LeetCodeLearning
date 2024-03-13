package com.company.leetcode2864;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/3/13
 */
public class SolutionTest {

    @Test
    public void maximumOddBinaryNumber() {
        String s = "001";
        Solution solution = new Solution();
        String result = solution.maximumOddBinaryNumber(s);
        assertEquals("001", result);
    }

    @Test
    public void maximumOddBinaryNumber_2() {
        String s = "0101";
        Solution solution = new Solution();
        String result = solution.maximumOddBinaryNumber(s);
        assertEquals("1001", result);
    }
}