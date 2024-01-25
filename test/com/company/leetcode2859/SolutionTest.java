package com.company.leetcode2859;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/25
 */
public class SolutionTest {

    @Test
    public void sumIndicesWithKSetBits() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(10);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        int k = 1;
        Solution solution = new Solution();
        int result = solution.sumIndicesWithKSetBits(nums, k);
        assertEquals(13, result);
    }
}