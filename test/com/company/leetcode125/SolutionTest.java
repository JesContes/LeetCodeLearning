package com.company.leetcode125;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindromeWhenHavaOtherCharacter() {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(s);
        assertTrue(result);
    }

    @Test
    public void isPalindromeWhenEmptyString() {
        String s = "   ";
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(s);
        assertTrue(result);
    }

    @Test
    public void isPalindromeWhenOnlyWeWantCharacter() {
        String s = "race a car";
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(s);
        assertFalse(result);
    }
}