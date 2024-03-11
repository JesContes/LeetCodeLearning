package com.company.leetcode2129;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/3/11
 */
public class SolutionTest {

    @Test
    public void capitalizeTitle() {
        String title = "capiTalIze tHe titLe";
        Solution solution = new Solution();
        String result = solution.capitalizeTitle(title);
        assertEquals("Capitalize The Title", result);
    }

    @Test
    public void capitalizeTitle_2() {
        String title = "First leTTeR of EACH Word";
        Solution solution = new Solution();
        String result = solution.capitalizeTitle(title);
        assertEquals("First Letter of Each Word", result);
    }

    @Test
    public void capitalizeTitle_3() {
        String title = "i lOve leetcode";
        Solution solution = new Solution();
        String result = solution.capitalizeTitle(title);
        assertEquals("i Love Leetcode", result);
    }
}