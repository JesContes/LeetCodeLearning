package com.company.leetcode392;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isSubsequenceWhenTrue() {
        String s = "abc";
        String t = "ahbgdc";
        Solution solution = new Solution();
        assertTrue(solution.isSubsequence(s, t));
    }

    @Test
    public void isSubsequenceWhenFalse_2() {
        String s = "aaaaaa";
        String t = "bbaaaa";
        Solution solution = new Solution();
        assertFalse(solution.isSubsequence(s, t));
    }

    @Test
    public void isSubsequenceWhenFalse() {
        String s = "axc";
        String t = "ahbgdc";
        Solution solution = new Solution();
        assertFalse(solution.isSubsequence(s, t));
    }

    @Test
    public void isSubsequenceWhenEmpty() {
        String s = "";
        String t = "ahbgdc";
        Solution solution = new Solution();
        assertTrue(solution.isSubsequence(s, t));
    }
}