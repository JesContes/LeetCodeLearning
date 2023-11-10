package com.company.leetcode13;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void romanToIntSuccess() {
        Solution solution = new Solution();
        String s1 = "III";
        Assert.assertEquals(3, solution.romanToInt(s1));
        String s2 = "IV";
        Assert.assertEquals(4, solution.romanToInt(s2));
        String s3 = "IX";
        Assert.assertEquals(9, solution.romanToInt(s3));
        String s4 = "LVIII";
        Assert.assertEquals(58, solution.romanToInt(s4));
        String s5 = "MCMXCIV";
        Assert.assertEquals(1994, solution.romanToInt(s5));
    }
}