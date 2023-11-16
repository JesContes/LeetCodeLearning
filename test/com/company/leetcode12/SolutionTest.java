package com.company.leetcode12;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void intToRomanSuccess() {
        Solution solution = new Solution();
        int num = 3;
        Assert.assertEquals("III", solution.intToRoman(num));
        num = 4;
        Assert.assertEquals("IV", solution.intToRoman(num));
        num = 9;
        Assert.assertEquals("IX", solution.intToRoman(num));
        num = 58;
        Assert.assertEquals("LVIII", solution.intToRoman(num));
        num = 1994;
        Assert.assertEquals("MCMXCIV", solution.intToRoman(num));
    }
}