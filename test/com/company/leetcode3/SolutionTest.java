package com.company.leetcode3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring() {
        String s = "abcabcbb";
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(3, result);
    }

    @Test
    public void lengthOfLongestSubstring_2() {
        String s = "aab";
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(2, result);
    }
}