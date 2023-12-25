package com.company.leetcode1276;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2023/12/25
 */
public class SolutionTest {

    @Test
    public void numOfBurgers() {
        int tomatoSlices = 16;
        int cheeseSlices = 7;
        Solution solution = new Solution();
        List<Integer> result = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(6, result.get(1).intValue());
    }
}