package com.company.leetcode2866;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2023/12/21
 */
public class SolutionTest {

    @Test
    public void maximumSumOfHeights() {
        List<Integer> maxHeights = Arrays.asList(5,3,3,1,1);
        Solution solution = new Solution();
        long res = solution.maximumSumOfHeights(maxHeights);
        assertEquals(13, res);
    }

    @Test
    public void maximumSumOfHeights_2() {
        List<Integer> maxHeights = Arrays.asList(1000000000,1000000000,1000000000);
        Solution solution = new Solution();
        long res = solution.maximumSumOfHeights(maxHeights);
        assertEquals(3000000000L, res);
    }
}