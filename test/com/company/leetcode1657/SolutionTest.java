package com.company.leetcode1657;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void closeStringsWhenClose() {
        Solution solution = new Solution();
        String word1 = "abbccaad";
        String word2 = "bccddbba";
        assertTrue(solution.closeStrings(word1, word2));
    }

    @Test
    public void closeStringsWhenCharacterNotEqual() {
        Solution solution = new Solution();
        String word1 = "abbccaad";
        String word2 = "bccddbbae";
        assertFalse(solution.closeStrings(word1, word2));
    }

    @Test
    public void closeStringsWhenCharacterNumNotEqual() {
        Solution solution = new Solution();
        String word1 = "abbccaad";
        String word2 = "aabccaad";
        assertFalse(solution.closeStrings(word1, word2));
    }
}