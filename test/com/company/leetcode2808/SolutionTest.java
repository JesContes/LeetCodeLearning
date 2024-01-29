package com.company.leetcode2808;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/30
 */
public class SolutionTest {

    @Test
    public void minimumSeconds() {
        List<Integer> nums = Arrays.asList(1,2,1,2);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(1, result);
    }

    @Test
    public void minimumSeconds_2() {
        List<Integer> nums = Arrays.asList(2,1,3,3,2);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(2, result);
    }

    @Test
    public void minimumSeconds_3() {
        List<Integer> nums = Arrays.asList(2,1);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(1, result);
    }

    @Test
    public void minimumSeconds_4() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(1, result);
    }

    @Test
    public void minimumSeconds_5() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 3);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(1, result);
    }

    @Test
    public void minimumSeconds_6() {
        List<Integer> nums = Arrays.asList(5, 5, 5);
        Solution solution = new Solution();
        int result = solution.minimumSeconds(nums);
        assertEquals(0, result);
    }
}